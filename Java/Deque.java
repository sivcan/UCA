import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {   //Node for the deque

        private Item item;
        private Node prev;
        private Node next;

    }

    public Deque() {}

    public boolean isEmpty() {  //Function to check if the deque is empty or not.
        return 0 == N;
    }

    public int size() { //Returns the size of the deque.
        return N;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

            public Node curr = first;


            public boolean hasNext() {     //checks if the deque hasNext element or not.
                return curr != null;
            }


            public Item next() {       //Returns the next item on the deque.
                if(curr == null)
                    throw new NoSuchElementException();
                Item item = curr.item;
                curr = curr.next;
                return item;
            }


            public void remove() {
                throw new UnsupportedOperationException();
            }
    }

    public void addFirst(Item item) {
        if(item == null)
            throw new NullPointerException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(isEmpty())
            last = first;
        else
            oldFirst.prev = first;
        N++;  //Incrementing the size of the list
    }

    public void addLast(Item item) {
        if(item == null)
            throw new NullPointerException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;

        if(isEmpty())       //Corner cases
            first = last;
        else
            oldLast.next = last;
        N--;  //decrementing the size of the list.
    }

    public static void main(String args[]) {
        Deque<String> dq = new Deque<String>();
        Iterator<String> x = dq.iterator();
        System.out.println(dq.isEmpty());
        System.out.println(dq.size());

        dq.addFirst("Sivcan");
        dq.addFirst("DeaMan");
        dq.addFirst("Holy!");
        while(x.hasNext()) {
            System.out.println(x.next());
        }

        // x.addLast("ML");
        // x.addLast("DP");
        // x.addLast("Algo");
        //
        // System.out.println();

    }

}
