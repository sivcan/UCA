#include <stdio.h>
//GeeksForGeeks Difference between the bits question.
//First Solution : Time Complexity O(n^2)
int main()
{
    int arr[] = {1, 3, 5};
    int count = 0;
    int n = sizeof(arr)/sizeof(arr[0]);
    for(int i = 0;  i < n; i++)
    {
        int val = arr[i];
        for(int j = i + 1; j < n; j++)
        {
            int interm = 0;
            int x = val ^ arr[j];
            while(x)
            {
                if((x&1)) interm++;
                x = x >> 1;
            }
            interm *= 2;
            count += interm;
        }
    }
    printf("The bits difference  = %d\n", count);
}
