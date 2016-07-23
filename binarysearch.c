#include <stdio.h>

int main()
{
    printf("\nProgram to implement binary search in an iterative approach.");
    int arr[] = {1,4,8,9,11,13,17,18};
    int data = 9;
    int mid;
    int low = 0;
    int high = 8;
    int flag = 1;
    while(low <= high)
    {
        mid = (low+high)/2;
        if(arr[mid] == data)
        {
            printf("\nData found at position : %d\n", mid);
            flag = 0;
            break;
        }
        else if(data > arr[mid])
        {
            low = mid + 1;
        }
        else if(data < arr[mid])
        {
            high = mid - 1;
        }
    }
    if(flag)
    {
        printf("\nData not found.\n");
    }

    return 0;
}
