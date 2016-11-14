import java.util.*;

class GraphBFS {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private int[] edgeTo;

    GraphBFS(int v) {
        this.V = v;
        this.E = 0;
        adj = new LinkedList[V];
        edgeTo = new int[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
            edgeTo[i] = -1;
        }

    }

    public int vertexSize() {
        return V;
    }

    public void addEdge(int v, int w){
        this.adj[v].add(w);
        E += 1;
    }

    public void BFS(int v) {

        bfs(v);
        //Under test : Code for finding the shortest path between the two nodes. Function arguments become BFS(int x, int v)..
        // boolean flag = false;
        // System.out.print(x);
        // for(int i = 0; i < edgeTo.length; i++) {
        //     if(edgeTo[i] == v) {
        //         flag = true;
        //         System.out.print(" -> " + i);
        //     }
        // }
        //
        // if(flag == false) {
        //     System.out.println("\nA path doesn't exist from " + x);
        // }
    }

    private void bfs(int x) {
        boolean[] marked = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        Integer w;
        q.add(x);
        marked[x] = true;
        while(!q.isEmpty()) {
            w = q.poll();
            System.out.println(w);
            for(int v : adj[w]) {
                if(!marked[v]) {
                    marked[v] = true;
                    edgeTo[v] = w;
                    q.add(v);
                }
            }
        }
    }

}

public class GraphTheoryBFS {
    public static void main(String args[]) {
        System.out.println("BFS Implementation");
        GraphTheoryBFS y = new GraphTheoryBFS();
        GraphBFS x = new GraphBFS(5);
        x.addEdge(0,1);
        x.addEdge(0,2);
        x.addEdge(1,2);
        x.addEdge(2,0);
        x.addEdge(2,3);
        x.addEdge(3,3);
        x.BFS(2);
    }
}
