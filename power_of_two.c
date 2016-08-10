#include <stdio.h>

int main()
{
    int n;
    scanf("%d", &n);
    if(n < 0) n = -n;
    if(n & (n-1))
    {
        printf("\nNot a power of two.\n");
    }
    else
    {
        printf("\nIt is a power of two.\n");
    }
    return 0;
}
