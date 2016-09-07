#include <stdio.h>
#define ll long long int

ll * fast_atoi(const char *str)
{
    ll val[2] = {0};
    while (*str != ' ') {
        val[0] = val[0]*10 + (*str++ - '0');
    }
    *str++;
    while(*str){
        val[1] = val[1]*10 + (*str++ - '0');
    }

    return val;
}

int main(){
    printf("\nProgram to do fast_atoi!");
    char number[]={"25223232434 1734324324234"};
    ll *t;
    t = fast_atoi(number);

    printf("\nResult = %lld & %lld\n", t[0], t[1]);


    return 0;
}
