#include <iostream>
#include <algorithm>
int n = 0;
using namespace std;

void max_heapify(int arr[], int i, int n) {
    int left = 2*i;
    int right = 2*i + 1;
    int largest = i;
    if((left < n) && (arr[left] > arr[i])) {
        largest = left;
    }
    if((right < n) && (arr[right] > arr[largest])) {
        largest = right;
    }

    if(largest != i) {
        swap(arr[i], arr[largest]);
        max_heapify(arr, largest,n);
    }
}

void display(int arr[]) {

    cout<<"\nRoot = "<<arr[1]<<endl;
    for(int i = 1; i < n/2; i++) {
           cout<<"\nParent = "<<arr[i];
           cout<<" || Left Child = "<<arr[2*i];
           cout<<" || Right Child = "<<arr[2*i + 1];
    }
    cout<<endl;
}

void build_maxHeap(int arr[]) {
    for(int i = n/2; i >= 1; i--) {
        max_heapify(arr,i,n);
    }
}

//HeapSort Logic
void HeapSort(int arr[]) {

    build_maxHeap(arr); //First build a max_heap
    int heapSize = n;   //Initialize HeapSize with the length of the array
    for(int i = n-1; i >= 2; i--) {  //Loop from Length of array down to 2.
        swap(arr[1], arr[i]);       //Swap the positions of arr[1] with arr[i]
        heapSize -= 1;              //Decrease the heapsize by 1
        max_heapify(arr,1,heapSize);   //Call the max_heapify function
    }

}

int main() {
     cout<<"Heap & HeapSort (max_heapify).\n";

     int arr[] = {0,7,2,8,9,11,6,7};
     n = sizeof(arr)/sizeof(arr[0]);
     //display(arr);

     cout<<"\nAfter heap sorting :\n";

     HeapSort(arr);

     for(int i = 1; i < n; i++) {
         cout<<arr[i]<<" ";
     }
     cout<<"\n";
     return 0;
}
