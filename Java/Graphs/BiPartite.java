
class Graphed extends Graphz {
    static final boolean RED = true;

    Graphed(int v) {
        super(v);
    }

    public void bipartite(int v) {
        //v.color = RED;
    }
}

public class BiPartite {

    public static void main(String args[]) {
        Graphed x = new Graphed(5);
        x.addEdge(0,4);
        x.addEdge(4,3);
        x.addEdge(3,0);
        x.addEdge(3,2);
        x.addEdge(2,1);
    }
}
