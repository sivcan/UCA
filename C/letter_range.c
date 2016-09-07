#include <stdio.h>

int main()
{
    printf("\nGetting the letter range in 1...26!");
    int i = 'g' & '\x1F';
    int k = 'Q' & '\x1F';
    printf("\n%d\n",i);
    printf("\n%d\n", k);
    return 0;
}
