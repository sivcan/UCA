#include <stdio.h>
#include <stdlib.h>

int randomPivot(int left, int right) {
    int r = rand() % (right-left+1);
    return (left + r);
}

void swap(int *x, int *y) {
    int *temp;
    temp = x;
    x = y;
    y = temp;
}

int partition(int arr[], int l, int h) {

    int pivot = arr[randomPivot(l,h)];
    int temp = pivot;
    pivot = arr[h];
    arr[h] = temp;

    int x = arr[h];

    int i = (l-1);
    int j;
    for(j = l; j < h; j++) {
        if(arr[j] <= x) {
            i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    temp = arr[j];
    arr[j] = arr[i+1];
    arr[i+1] = temp;
    return (i+1);

}

void quickSort(int A[], int l, int h) {
    if(l < h) {
        int p = partition(A,l,h);
        quickSort(A, l, p-1); //Left array
        quickSort(A,p+1,h);  //Right array
    }
}

int main() {
    printf("\nQuick Sort (randomized) \n");
    int arr[] = {1,8,3,9,2,8};
    int n = sizeof(arr)/sizeof(arr[0]);
    // Function call to quickSort
    quickSort(arr,0,n-1);
    // After sorting.
    for(int i = 0; i < n; i++) {
            printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}
