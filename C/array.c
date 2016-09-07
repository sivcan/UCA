#include <stdio.h>

int main()
{
    int n;
    printf("\nEnter the size of the array : ");
    scanf("%d", &n);
    printf("\nEnter the elements of the array : ");
    int arr[n];
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    int temp = 1;
    int left[n], right[n];
    left[0]=right[n-1]=1;
    for(int i = 1; i < n; i++)
    {
        temp *= arr[i-1];
        left[i] = temp;
    }
    temp = 1;
    for(int i = n-1; i >= 1; i--)
    {
        temp *= arr[i];
        right[i-1]=temp;
    }

    for(int i = 0; i < n; i++)
    {
        arr[i] = left[i] * right[i];
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}
