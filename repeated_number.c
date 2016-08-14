#include <stdio.h>

int main() {
    printf("\nRepeated number find.");
    int arr[] = {1,2,3,7,4,5,6,7};
    int n = sizeof(arr)/sizeof(arr[0]);
    int sum = 0;
    for(int i = 0; i < n; i++) sum += arr[i];
    
    n = (n*(n-1))/2;

    printf("\nThe repeated number is : %d\n", (sum - n));
    return 0;
}
