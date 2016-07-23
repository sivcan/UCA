#include <stdio.h>
#include <sys/time.h>
void bubblesorter(int arr1[], int size)
{
    for(int i = 0; i < size-1; i++) //Applying bubble sort on arr1
    {
        for(int j = 0; j < size-1; j++)
        {
            if(arr1[j] > arr1[j+1])
            {
                int temp = arr1[j];
                arr1[j] = arr1[j+1];
                arr1[j+1] = temp;
            }
        }
    }
}

int main() {
    int arr1[8000], arr2[16000];
    int k=0;
    for(int i = 8000; i >= 1; i--) //Initializing Array.
    {
        arr1[k++] = i;
    }
    k=0;
    for(int i = 16000; i >= 1; i--) //Initializing Array.
    {
        arr2[k++] = i;
    }

    struct timeval t1, t2;
    gettimeofday(&t1,NULL); //Calling function to get time of the day
    bubblesorter(arr1,8000);
    gettimeofday(&t2,NULL);
    long int result1 = (t2.tv_sec * 1000000 + t2.tv_usec) - (t1.tv_sec * 1000000 + t1.tv_usec);
    printf("Time for 8000 size array worst case : %ld\n", result1);

    gettimeofday(&t1,NULL); //Calling function to get time of the day
    bubblesorter(arr2,16000);
    gettimeofday(&t2,NULL);
    long int result2 = (t2.tv_sec * 1000000 + t2.tv_usec) - (t1.tv_sec * 1000000 + t1.tv_usec);
    printf("Time for 16000 size array worst case : %ld\n", result2);
    //Division result
    printf("%gms\n", (double)result2/(double)result1);

    return 0;
}
