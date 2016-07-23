#include <stdio.h>

int arr[] = {1,4,8,9,11,13,17,18};

int binary(int low, int high, int data)
{
    if(low > high)
    {
        return 0;
    }
    else
    {
        int mid=(low+high)/2;
        if(data == arr[mid])
        {
            return 1;
        }
        else if(data > arr[mid])
            binary(mid+1, high, data);
        else
            binary(low, mid-1, data);
    }
}

int main()
{
    printf("\nProgram to implement binary search in a recursive approach.");
    int data = 21;
    if(binary(0,7,data))
    {
        printf("\nData found!\n");
    }
    else
    {
        printf("\nData not found.\n");
    }
}
2
