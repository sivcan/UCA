#include <stdio.h>
#include <string.h>
// Global variable.

unsigned char charset[]={"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

unsigned char revchar(char ch)
{
   if (ch >= 'A' && ch <= 'Z')
      ch -= 'A';
   else if (ch >= 'a' && ch <='z')
      ch = ch - 'a' + 26;
   else if (ch >= '0' && ch <='9')
      ch = ch - '0' + 52;
   else if (ch == '+')
      ch = 62;
   else if (ch == '/')
      ch = 63;
   return(ch);
}

int base64_encode(unsigned char in[], unsigned char out[], int len, int newline_flag) {
   int idx,idx2,blks,left_over;
   // Since 3 input bytes = 4 output bytes, figure out how many even sets of 3 input bytes
   // there are and process those. Multiplying by the equivilent of 3/3 (int arithmetic)
   // will reduce a number to the lowest multiple of 3.
   blks = (len / 3) * 3;
   for (idx=0,idx2=0; idx < blks; idx += 3,idx2 += 4) {

      out[idx2] = charset[in[idx] >> 2];
      out[idx2+1] = charset[((in[idx] & 0x03) << 4) + (in[idx+1] >> 4)];  //0x03 (11)
      out[idx2+2] = charset[((in[idx+1] & 0x0f) << 2) + (in[idx+2] >> 6)]; //0x0f (1111)
      out[idx2+3] = charset[in[idx+2] & 0x3F];  //0x3f = 63 (1111)

      // The offical standard requires insertion of a newline every 76 chars
      if (!(idx2 % 77) && newline_flag) {
         out[idx2+4] = '\n';
         idx2++;
      }
   }

   left_over = len % 3;
   if (left_over == 1) {
      out[idx2] = charset[in[idx] >> 2];
      out[idx2+1] = charset[(in[idx] & 0x03) << 4];
      out[idx2+2] = '=';
      out[idx2+3] = '=';
      idx2 += 4;
   }
   else if (left_over == 2) {
      out[idx2] = charset[in[idx] >> 2];
      out[idx2+1] = charset[((in[idx] & 0x03) << 4) + (in[idx+1] >> 4)];
      out[idx2+2] = charset[(in[idx+1] & 0x0F) << 2];
      out[idx2+3] = '=';
      idx2 += 4;
   }
   out[idx2] = '\0';
   return(idx2);
}

int base64_decode(unsigned char in[], unsigned char out[], int len){
   unsigned char ch;
   int idx,idx2,blks,left_over;

   if (in[len-1] == '=')
      len--;
   if (in[len-1] == '=')
      len--;

   blks = (len / 4) * 4;
   for (idx=0,idx2=0; idx2 < blks; idx += 3,idx2 += 4) {
      out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
      out[idx+1] = (revchar(in[idx2+1]) << 4) + (revchar(in[idx2+2]) >> 2);
      out[idx+2] = (revchar(in[idx2+2]) << 6) + revchar(in[idx2+3]);
   }

   left_over = len % 4;
   if (left_over == 2) {
      out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
      out[idx+1] = (revchar(in[idx2+1]) << 4);
      idx += 2;
   }
   else if (left_over == 3) {
      out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
      out[idx+1] = (revchar(in[idx2+1]) << 4) + (revchar(in[idx2+2]) >> 2);
      out[idx+2] = revchar(in[idx2+2]) << 6;
      idx += 3;
   }
   out[idx] = '\0';
   return(idx);
}


int main()
{
   unsigned char text1[]={"hello sivcan"},
                 text2[]={"3.14159"},
                 code1[]={"QmFzZSA2NC4="},
                 code2[]={"YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXo="},
                 out2[1024],
                 out[1024];

   base64_encode(text1,out,strlen(text1),0);
   puts(out);
   // encode(text2,out,strlen(text2),0);
   // puts(out);
   base64_decode(out,out2,strlen(out));
   puts(out2);

   // decode(code2,out,strlen(code2));
   // puts(out);
   return 0;
}
