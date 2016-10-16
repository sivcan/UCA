import java.util.*;

class Priority {

        int averageTime;
        int meanTime;

    Priority(int a, int b) {
        this.averageTime = a;
        this.meanTime = b;
    }

    int getAverageTime() {
        return averageTime;
    }

    int getMeanTime() {
        return meanTime;
    }

}

class Process {

    String processName;

    Process(String x) {
        processName = x;
    }

    public String getName() {
        return this.processName;
    }
}

class ByAvg implements Comparator {

    public int compare(Object o1, Object o2) {
        Priority p1 = (Priority) o1;
        Priority p2 = (Priority) o2;
        if(p1.getAverageTime() == p2.getAverageTime()) return 0;
        else if(p1.getAverageTime() > p2.getAverageTime()) return 1;
        return -1;
    }

}

class ByMean implements Comparator{

    public int compare(Object o1, Object o2) {
        Priority p1 = (Priority) o1;
        Priority p2 = (Priority) o2;
        if(p1.getMeanTime() == p2.getMeanTime()) return 0;
        else if(p1.getMeanTime() > p2.getMeanTime()) return 1;
        return -1;
    }
}

public class SchedulerTree{

    class Node {
        Process x;
        Priority p;
        Node left;
        Node right;

        Node(Priority xP, Process xD) {
            x = xD;
            p = xP;
            left = right = null;
        }
    }

    public Node root = null;

    public void insert(Priority p, Process q, Comparator c) {
        root = insertNode(root, p, q, c);
    }

    private Node insertNode(Node root, Priority p, Process q, Comparator c) {
        if(root == null) {
            return new Node(p,q);
        }
        if(c.compare(root.p, p) < 0) {
            root.left = insertNode(root.left, p, q, c);
        }
        else if(c.compare(root.p, p) > 0) {
            root.right = insertNode(root.right, p, q, c);
        }
        return root;
    }


    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.x.getName());
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        System.out.println("Implementing Linux Scheduler using BST.");
        SchedulerTree x = new SchedulerTree();

        Comparator c1 = new ByAvg();
        Comparator c2 = new ByMean();

        Process pro1 = new Process("Process 1");
        Process pro2 = new Process("Process 2");
        Process pro3 = new Process("Process 3");

        Priority p1 = new Priority(8,20);
        Priority p2 = new Priority(5,25);
        Priority p3 = new Priority(10,30);


        x.insert(p1, pro1, c1);
        x.insert(p2, pro2, c1);
        x.insert(p3, pro3, c1);

        x.inorder(x.root);
    }

}
