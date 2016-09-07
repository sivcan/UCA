#include <stdio.h>

int main()
{
    int n;
    printf("\nEnter the size of the square matrix :");
    scanf("%d", &n);
    int a[n][n];
    printf("\nEnter the values : ");
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(a[i][j] == 0)
            {
                for(int k = 0; k < n; k++)
                {
                    a[i][k] = 2;
                    a[k][j] = 2;
                }

            }
        }
    }
    printf("\nThe result is : \n");
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(a[i][j] == 2)
            {
                printf("0 ");
            }
            else
            {
                printf("%d ", a[i][j]);
            }
        }
        printf("\n");
    }

}
