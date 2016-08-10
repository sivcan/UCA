#include <stdio.h> 

/*
Output should be:
YWJj

My4xNDE1OQ==

Base 64.

abcdefghijklmnopqrstuvwxyz
*/

int main() 
{  
   unsigned char text1[]={"abc"}, 
                 text2[]={"3.14159"}, 
                 code1[]={"QmFzZSA2NC4="}, 
                 code2[]={"YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXo="}, 
                 out[1024]; 
   
   encode(text1,out,strlen(text1),0); 
   puts(out); 
   encode(text2,out,strlen(text2),0); 
   puts(out); 
   decode(code1,out,strlen(code1)); 
   puts(out); 
   decode(code2,out,strlen(code2)); 
   puts(out); 
   
   getchar(); 
   return 0; 
}  
