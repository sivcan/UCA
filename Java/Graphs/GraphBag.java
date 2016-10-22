import java.util.*;


class Graph {
    private int V, E;
    public Bag[] adj;

    public Graph(int v) {
        adj = new Bag[v];

        for(int i = 0; i < v; i++) {
            adj[i] = new Bag();
        }

        this.E = 0;
        this.V = v;
    }

    public int vertexSize() {
        return V;
    }

    public void addEdge(int v, int w) {
        this.adj[v].enqueue(w);
        //this.adj[w].enqueue(v);
        E += 1;
    }

    public void adj(int v) {
        Iterator ite = adj[v].iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

    public void findPath(Graph g, int v) {
        DFS ob = new DFS(g, v);
        ob.displayPath();
        System.out.println("\nThe graph has a path from " + v + " to  " + (v - 1) + " is : " + ob.hasPathTo(v-1)); //Just testing.
    }


    public void pathBetween(Graph g, int v, int w){
        DFS ob = new DFS(g, v);
        if(ob.hasPathTo(w)) {
            ob.displayPath();
        }
    }

    private class DFS {
        private boolean[] marked;
        private ArrayList<Integer> edgeTo = new ArrayList<>();

        public DFS(Graph g, int s) {
            marked = new boolean[g.vertexSize()];
            dfs(g,s);
        }

        private void displayPath() {
            for(int i = 0; i < edgeTo.size(); i++) {
                    System.out.print(edgeTo.get(i) + " ");
            }
        }

        private void dfs(Graph g, int v) {
            marked[v] = true;
            edgeTo.add(v);
            Iterator ite = g.adj[v].iterator();
            while(ite.hasNext()) {
                int x = (int)ite.next();
                if(!marked[x]) {
                    dfs(g,x);
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
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
        System.out.print("Graph Implementation.\n");
        Graph gp = new Graph(4);
        //gp.addEdge(3,6);
        //gp.addEdge(4,2);

        //Display function call.
        //gp.adj(2);
        //gp.adj(4);
        gp.addEdge(0, 1);
        gp.addEdge(0, 2);
        gp.addEdge(1, 2);
        gp.addEdge(2, 0);
        //gp.addEdge(2, 3);
        gp.addEdge(3, 3);
        //Printing the connected path.
        gp.findPath(gp, 2);
        gp.pathBetween(gp, 1,2);
    }
}
