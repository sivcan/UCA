import java.util.*;

public class RadixSort {

    private void countSort(int arr[], int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[11];
        Arrays.fill(count, 0);

        for(int i = 0; i < n; i++) { //Filling the count array
            count[ (arr[i]/exp) % 10]++;
        }

        for(int i = 1; i < 10; i++) { //Creating the cumiliative array
            count[i] += count[i-1];
        }

        for(int i = n - 1; i >= 0; i--) {
            output[ count[(arr[i]/exp) % 10] - 1] = arr[i];
            count[(arr[i]/exp) % 10]--;
        }

        for(int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public void count(int arr[]) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        for(int exp = 1; max/exp > 0; exp *= 10) {
            countSort(arr, arr.length, exp);
        }
    }

    public static void main(String args[]) {
        RadixSort x = new RadixSort();
        System.out.println("Radix Sort!");
        int[] arr = {3, 2, 34, 12, 34, 65, 43, 109};
        x.count(arr);
        System.out.println("After sorting the code is : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// msd(a, L, R, d) {
//
//
//
//     3rd for loop..
//     msd(a, L+count[i], L+count[i+1], d+1);
// }
