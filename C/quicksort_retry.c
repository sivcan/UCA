#include <stdio.h>
#include <stdlib.h>
 //Randomized QuickSort gurantees O(NlogN) time complexity.
void swapz(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}
int randomPivot(int left, int right) {
    int x = rand() % (right-left + 1);
    return (left + x);
}

int partition(int arr[], int l, int r) {
    swapz(&arr[r], &arr[randomPivot(l,r)]);
    int x = arr[r];
    int i = l-1;
    for(int j = l; j < r; j++) {
        if(arr[j] <= x) {
            i++;
            swapz(&arr[i], &arr[j]);
        }
    }
    i++;
    swapz(&arr[i], &arr[r]);
    return i;
}

void quicksort(int arr[], int l, int r) {
    if(l < r) {
        int p = partition(arr,l,r);
        quicksort(arr,0,p-1); //left array
        quicksort(arr,p+1,r);   //right array
    }
}
int main() {
    printf("\nQuickSort.\n");
    int arr[] = {9,6,5,0,8,2,4,7};
    int n = sizeof(arr)/sizeof(arr[0]);
    quicksort(arr,0,n-1);
    for(int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}
