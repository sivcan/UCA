#include <stdio.h>

int main()
{
    int arr[] = {13,18,5,7,9};
    int i = 4;
    int len;

    while(arr[i] > arr[i-1] && i >= 0) i--;

    printf("\nThe break position is : %d\n", arr[i]);

    int data = 9;
    int mid = i;
    int low = 0;
    int high = 4;
    int flag = 1;
    while(high <= low)
    {
        if(arr[mid] == data)
        {
            printf("\nData found at position : %d\n", mid);
            flag = 0;
            break;
        }
        else if(data > arr[mid])
        {
            high = mid - 1;
        }
        else if(data < arr[mid])
        {
            low = mid + 1;
        }
        mid = (low+high)/2;
    }
    if(flag)
    {
        printf("\nData not found.\n");
    }

    return 0;
}
