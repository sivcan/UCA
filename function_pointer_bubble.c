#include <stdio.h>
int compare(int x, int y) {
    return (x > y ? 1 : 0);
}

void bubbleSort(int arr[],int n,int (* cmp)(int, int)) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - 1; j++) {
            if(cmp(arr[j], arr[j+1])) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
int main() {
    printf("\nFunction Pointers and generic sort.");
    int arr[] = {'b','c', 'a', 'f'};
    int n = sizeof(arr)/sizeof(arr[0]);
    bubbleSort(arr, n, compare);
    for(int i = 0; i < n; i++) {
        printf("%c ", arr[i]);
    }
    printf("\n");
    return 0;
}
