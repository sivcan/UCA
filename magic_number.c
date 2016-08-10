#include <stdio.h>
#include <math.h>

int nth(int n)
{
    int ans = 0;
    int k = 1;
    int powz;
    while(n)
    {
        powz = (n)&1;
        ans += powz*pow(5,k);
        k++;
        n = n>>1;
    }
    return ans;
}

int main()
{
    printf("\nThe %dth magic number : %d\n", 5, nth(5));
    return 0;
}
