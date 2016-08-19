import java.io.*;
import java.util.*;

class linkedArray {
    int MAX = 10;
    static int top = 0;
    static void push(int []a,int x) {
        if (top == (a.length-1)) {
            expand(a,x);
        }
        else {
            a[top++] = x;
        }
        System.out.println("Insertion successful.");
    }

    static int pop(int []a) {
        if(top == 0) {
            System.out.println("List empty. Cannot pop");
            return 0;
        }
        else {
            return (a[--top]);
        }
    }

    static void expand(int []a, int x) {
        int [] temp = new int[a.length*2];
        for(int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        temp[a.length] = x;
        a = temp;
    }

    static void shrink(int []a) {
        //if suppose size if 4, and array is 16.. then make it half.
    }
    
    public static void main(String args[]) {
        int [] a = new int[4];
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size : ");
        n = scan.nextInt();
        System.out.println("Enter the elements : ");
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            push(a,x);
        }
        scan.close();

        for(int i = 0; i < a.length; i++) {
            System.out.print(i + " ");
        }

    }
}
