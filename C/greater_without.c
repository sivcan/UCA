#include <stdio.h>

int larger(int a, int b)
{
    return (b & ((a-b) >> 31) | a & (~(a-b) >> 31));
}

int smaller(int a, int b)
{
    return (a & ((a-b) >> 31) | b & (~(a-b) >> 31));
}

int main()
{
    printf("\nThe larger is : %d\n", larger(5,6));
}
