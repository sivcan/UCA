#include <stdio.h>
#include <string.h>

unsigned char charset[]={"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

unsigned char revchar(char ch) {
    if(ch >= 'A' && ch <= 'Z')
        ch -= 'A';
    else if(ch >= 'a' && ch <='z')
        ch = ch - 'a' + 26;
    else if(ch >= '0' && ch <= '9')
        ch = ch - '0' + 52;
    else if(ch == '+')
        ch = 62;
    else if(ch == '/')
        ch = 63;

    return (ch);
}

int base64_encode(unsigned char in[], unsigned char out[], int len, int new_flag) {
    int idx, idx2, blocks, left_over;

    blocks = (len / 3) * 3;

    for(idx = 0, idx2 = 0; idx < blocks; idx+=3, idx2+=4) {
        out[idx2] = charset[in[idx] >> 2];
        out[idx2+1] = charset[((in[idx] & 3) << 4) + (in[idx+1] >> 4) ];
        out[idx2+2] = charset[((in[idx+1] & 15) << 2) + (in[idx+2] >> 6)];
        out[idx2+3] = charset[((in[idx+2] & 63))];
    }

    left_over = len % 3;

    if(left_over == 1) {
        out[idx2] = charset[in[idx] >> 2];
        out[idx2+1] = charset[(in[idx] & 3) << 4];
        out[idx2+2] = '=';
        out[idx2+3] = '=';
        idx2+=4;
    }

    if(left_over == 2) {
        out[idx2] = charset[in[idx] >> 2];
        out[idx2+1] = charset[((in[idx] & 3) <<  4) + (in[idx+1] >> 4)];
        out[idx2+2] = charset[((in[idx+1] & 15) << 2)];
        out[idx2+3] = '=';
        idx2+=4;
    }
    out[idx2] = '\0';
    return idx2;

}

int base64_decode(unsigned char in[], unsigned char out[], int len) {
    int idx, idx2,blocks, left_over;
    if(in[len-1] == '=')
        len--;
    if(in[len-1] == '=')
        len--;

    blocks = (len / 4) * 4;
    for(idx = 0,idx2 = 0; idx2 < blocks; idx += 3, idx2 += 4) {
        out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
        out[idx+1] = (revchar(in[idx2+1]) << 4) + (revchar(in[idx2+2]) >> 2);
        out[idx+2] = (revchar(in[idx2+2]) << 6) + revchar(in[idx2+3]);
    }

    left_over = len % 4;

    if(left_over == 2) {
        out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
        out[idx+1] = (revchar(in[idx2+1]) << 4);
        idx += 2;
    }
    else if(left_over == 3) {
        out[idx] = (revchar(in[idx2]) << 2) + ((revchar(in[idx2+1]) & 0x30) >> 4);
        out[idx+1] = (revchar(in[idx2+1]) << 4) + (revchar(in[idx2+2]) >> 2);
        out[idx+2] = (revchar(in[idx2+2]) << 6);
        idx += 3;
    }
    out[idx] = '\0';
return idx;

}

int main() {
    unsigned char text1[] = {"hello sivcan"}, code1[]={"QmFzZSA2NC4="};
    unsigned char out[1024], out2[1024];

    //Base64 Encoder Call
    base64_encode(text1,out,strlen(text1),0);
    printf("%s\n", out);

    //Base64 Decoder Call
    base64_decode(code1, out2,strlen(code1));
    printf("\nThe decoded string is : %s\n", out2);


}
