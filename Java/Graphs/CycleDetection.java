import java.util.*;

class Graphz {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private boolean isCycle;
    private boolean[] marked;

    Graphz(int v) {
        this.V = v;

        adj = new LinkedList[v];
        marked = new boolean[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            marked[i] = false;
        }

        isCycle = false;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        E+=1;
    }

    public void CycleDetection() {
        dfs(0,-1);
        if(isCycle) {
            System.out.println("Cycle Detected : Successfully.");
        }
        else {
            System.out.println("No Cycle Present in the graph.");
        }
    }

    private void dfs(int v, int p) {
        marked[v] = true;
        for(int w : adj[v]) {
            if(!marked[w]) {
                dfs(w,v);
            }
            else if(w != p) {
                isCycle = true;
            }
        }
    }
}

public class CycleDetection {

    public static void main(String args[]) {
        Graphz x = new Graphz(5);
        x.addEdge(0,4);
        x.addEdge(4,3);
        x.addEdge(3,0);
        x.addEdge(3,2);
        x.addEdge(2,1);
        x.CycleDetection();
    }

}
