#include <stdio.h>
//GCD Extended

int gcd(int a, int b, int *x, int *y)
{
    if(a == 0)
    {
        *x = 0;
        *y = 1;
        return b;
    }

    int x1, y1;
    int gcdExtended = gcd(b%a, a, &x1, &y1);
    *x = y1 - (b/a) * x1;
    *y = x1;
    return gcdExtended;
}

int main()
{
    int a,b, x, y;
    scanf("%d %d", &a, &b);
    printf("\n The result is : %d and x = %d and y = %d\n", gcd(a,b,&x,&y), x, y);
    return 0;
}
