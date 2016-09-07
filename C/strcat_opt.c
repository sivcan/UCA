#include <stdio.h>

void strcats(char *s, char *t)
{
    while(*s!='\0')s++;
    while((*s++ = *t++));
}

void strncpys(char *s, char *t, int n)
{
    while(n-- && (*s++ = *t++));
    *s = '\0';
}

void strncats(char *s, char *t, int n)
{
    while(*s!='\0')s++;
    while(n-- && (*s++ = *t++));
}

int strends(char *s, char *t)
{
    while(*s++!='\0');
    return 1;
}
int main()
{
    char s[100] = "Hello, ";
    char *t = "how are you?";
    char *a = "hey man sup hey";
    char *b = "ok";
    strcats(s,t);
    printf("After concatination : %s\n", s);
    strncpys(s,t,9);
    printf("\nAfter strncpy : %s\n", s);
    strncats(s,t,11);
    printf("\nAfter strncat : %s\n", s);
    if(strends(a,b))
    {
        printf("\nThe string is present at the end\n");
    }
    else
    {
        printf("\nThe string is not present at the end.\n");
    }
    return 0;
}
