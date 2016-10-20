import java.util.*;


class Graph {
    int V, E;
    Bag[] adj;

    public Graph(int v) {
        adj = new Bag[v];
        E = 0;
        V = v;
    }


    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E += 2;
    }

    public void adj(int v) {
        Iterator ite = adj[v].iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

}

class Node {
    int key;
    Node next;

    Node(int item) {
        this.key = item;
        this.next = null;
    }
}



class Bag implements Iterable<Integer> {
    Node first, last;
    int size;

    Bag() {
        size = 0;
    }

    public void enqueue(int n) {
        Node curr = last;
        last = new Node(n);

        if(size == 0) {
            first = last;
        }
        else {
            curr.next = last;
        }
        size++;
    }

    public Iterator<Integer> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Integer> {

        Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }


        public Integer next() {
            Integer temp = curr.key;
            curr = curr.next;
            return temp;
        }


        public void remove() {
            //do nothing.
        }
    }

}



public class GraphBag {

    public static void main(String args[]) {
        System.out.print("Graph Implementation.");
        Graph gp = new Graph(7);
        gp.addEdge(2,3);
        gp.addEdge(2,4);
        gp.addEdge(2,8);
        gp.addEdge(3,6);
        gp.addEdge(4,2);

        gp.adj(2);
    }
}
