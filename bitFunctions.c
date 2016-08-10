int bitInverter(int x, int n, int z)
{
    return ((~(~0<<n)<<p)^x);
}

int bitAnd(int x, int y)
{
    return (!(!x|!y));
}

int bitXor(int x, int y)
{
    return (~x&y)|(~y&x);
}

int main()
{
    printf("\nThe result is : %d", bitInverter(5,2,1));
    return 0;
}
