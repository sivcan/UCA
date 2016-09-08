class QueueOfStrings {

    private class Node {
        String item;
        Node next;
    }

    private Node first = null;
    private Node last = null;

    boolean isEmpty() {
        return first == null;
    }

    void enqueue(String item) {  //We add it to the end of the list.
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null; //making the last node point to null reference.

        if(isEmpty())  //if the queue is empty, then let first point to the last node. i.e. only 1 node in the queue.
            first = last;
        else
            oldLast.next = last;
    }

    String dequeue() {    //We remove from the front of the list.
        String item = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        return item;
    }

    void display() {
        Node disp = first;
        while(disp != null) {
            System.out.println(disp.item);
            disp = disp.next;
        }
    }

    public static void main(String args[]) {
        QueueOfStrings obj = new QueueOfStrings();

        obj.enqueue("Machine Learning.");
        obj.enqueue("Data Analysis");
        obj.enqueue("Queue!");
        obj.display();

        obj.dequeue();
        obj.dequeue();
        System.out.println("After dequeing : ");
        obj.display();
    }

}
