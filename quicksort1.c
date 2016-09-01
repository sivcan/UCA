#include <stdio.h>
void swap(int *i, int *j) {
    int t;
    t = *i;
    *i = *j;
    *j = t;
}

void quickSort(int arr[], int low, int high) {
    if(low < high)
    {
        int piv = partition(arr, low, high);
        quickSort(arr, low, piv-1);
        quickSort(arr, piv+1, high);
    }
}

int main() {

    int arr[] = {3,4,2,2,1,-2,0};

    int n = sizeof(arr)/sizeof(arr[0]);

    quickSort(arr,0,n-1);

    for(int i = 0; i < n; i++) {
        printf("%d ",arr[i]);
    }

}
