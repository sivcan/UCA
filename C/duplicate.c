// Q. Unsorted array a[n], print all duplicate entries in O(n) time and O(1) space.
// 0 < n < 100000
// Max occurrence of a number = 2

#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[] = {5,8,6,2,3,1,5,8,7,3,6};
    int n = sizeof(arr)/sizeof(arr[0]);
    for(int i = 0; i < n; i++) {
        int x = abs(arr[i]);
        if(arr[x] < 0) {
            printf("Duplicate : %d\n", x);
        }
        else {
            arr[x] *= -1;
        }
    }
    printf("\n");
    return 0;
}
