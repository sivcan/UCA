import java.util.*;
import java.io.*;

class GenericLinkedList <Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first = null;

    public void insert(Item data) {
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

    public Item pop() {
        if(isEmpty()) {
            System.out.println("The list is empty.");
            return null;
        }
        Node oldFirst = first;
        Item val = first.item;
        first = first.next;
        oldFirst = null; //Let the garbage collector reclaim the memory. We don't need the reference of the first node anymore.
        return val;
    }

    public void clear() {
        Node iter = first;
        while(first!=null) {
            iter = first;
            first = first.next;
            iter = null;
        }
    }
    public static void main(String args[]) {

        System.out.println("Linked List as a push down Stack.\nEnter the number of elements : ");
        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("Enter the integer elements : ");

        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            list.insert(x);
        }
        System.out.println("Printing the elements : ");
        list.display();

        list.pop();
        System.out.println("Printing the elements after popping top : ");
        list.display();


        list.clear();
        GenericLinkedList<String> list2 = new GenericLinkedList<String>();
        System.out.println("Enter the " + n + " Strings : ");
        for(int i = 0; i < n; i++) {
            String x = scan.nextLine();
            list2.insert(x);
        }
        System.out.println("Printing the elements : ");
        list2.display();

        list2.pop();
        System.out.println("Printing the elements after popping top : ");
        list2.display();


    }

}
