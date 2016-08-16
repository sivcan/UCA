#include <iostream>
#include <vector>
#include <algorithm>

int n;
using namespace std;

void max_heapify(int arr[], int i, int n) {
    int left = 2*i;
    int right = left + 1;
    int largest = i;

    if((left < n) && (arr[left] > arr[i])){
        largest = left;
    }

    if((right < n) && (arr[right] > arr[largest])) {
        largest = right;
    }

    if(largest != i) {
        swap(arr[i], arr[largest]);
        max_heapify(arr, largest, n);
    }
}

void build_maxHeap(int arr[]) {
    for(int i = n/2; i >= 1; i--) {
        max_heapify(arr,i,n);
    }
}

void heapSort(int arr[]) {
    build_maxHeap(arr);
    int heap_size = n;
    for(int i = n-1; i >= 2; i--) {
        swap(arr[1], arr[i]);
        heap_size -= 1;
        max_heapify(arr, 1, heap_size);
    }
}


int main() {
    cout<<"\nProgram to implement Heapsort.\n";
    cout<<"\nEnter the size of the array  :";

    cin>>n;
    n++;
    int arr[n];

    for(int i = 1; i < n; i++) {
        cin>>arr[i];
    }

    //Calling the heapsort function5
    heapSort(arr);

    cout<<"\nAfter sorting : \n";

    for(int i = 1; i < n; i++) {
        cout<<arr[i]<<" ";
    }
    cout<<endl;

    return 0;

}
