import java.util.*;
import java.io.*;

class LinkedList {

    private class Node {
        int item;
        Node next;
    }

    private Node first = null;

    void insert(int data) {
        Node oldFirst = first;
        first = new Node();
        first.item = data;
        first.next = oldFirst;
    }

    void display() {
        Node iter = first;
        while(iter != null) {
            System.out.println(iter.item + " ");
            iter = iter.next;
        }
    }

    boolean isEmpty() {
        return first == null;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("The list is empty.");
            return -999;
        }
        int val = first.item;
        first = first.next;
        return val;
    }

    public static void main(String args[]) {

        System.out.println("Linked List.\nEnter the number of elements : ");
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("Enter the elements : ");

        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            list.insert(x);
        }
        System.out.println("Printing the elements : ");
        list.display();

        int x = list.pop();
        System.out.println("Printing the elements after popping top : " + x);
        list.display();



    }

}
