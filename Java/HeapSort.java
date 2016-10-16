class HeapSort {

    private int swap(int getMe, int blah) {
        return getMe;
    }

    private void max_heapify(int[] arr, int i, int n) {
        int left = 2*i;
        int right = left+1;
        int largest = i;

        if(left < n && arr[left] > arr[i]) {
                largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
                largest = right;
        }

        if(largest != i) {
            arr[i] = swap(arr[largest], arr[largest] = arr[i]); // Haha! Just a creative way of swapping. :P
            max_heapify(arr,largest,n);
        }
    }

    private void build_maxheap(int[] arr) {
        for(int i = arr.length/2; i >= 1; i--) {
            max_heapify(arr, i, arr.length);
        }
    }

    public void heapSort(int[] arr) {
        build_maxheap(arr);
        int heap_size = arr.length;
        for(int i = arr.length - 1; i >= 1; i--) {
            arr[1] = swap(arr[i], arr[i] = arr[1]);
            heap_size -= 1;
            max_heapify(arr, 1, heap_size);
        }
    }

    public void increase_key(int arr[], int i, int key) {
        if(key < arr[i] && i > arr.length)
            System.out.println("Key error || Length error!");
        arr[i] = key;
        while(i > 1 && arr[i/2] < arr[i]) {
            arr[i/2] = swap(arr[i], arr[i] = arr[i/2]);
            i /= 2;
        }
    }

    public static void main(String args[]) {
        System.out.println("HeapSort Functions : heapSort, max_heapify, build_maxheap, increase_key");
        HeapSort x = new HeapSort();
        int[] arr = {0, 16, 3, 2, 1, 5, 27, 23, 90, -1};  //We are not using the zeroth index of the array.
        System.out.println("Initially the array is : ");

        for(int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nThe size is : " + arr.length);
        System.out.println("\nHeapSorting...");
        x.heapSort(arr);

        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        x.increase_key(arr,3,45);
        x.increase_key(arr,5,102);
        x.heapSort(arr);
        System.out.println("\nAfter increasing keys to 45 and 102 and heapSorting");
        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


}
