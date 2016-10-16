import java.util.*;

class Priority {

    class Node {
        int averageTime;
        int meanTime;

        Node(int a, int b) {
            averageTime = a;
            meanTime = b;
        }
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
}

class ByAvg implements Comparator {

    public int compare(Object o1, Object o2) {
        Priority p1 = (Priority) o1;
        Priority p2 = (Priority) o2;
        if(p1.getAverageTime() == p2.getAverageTime()) return 0;
        else if(p1.getAverageTime() > p2.getAverage()) return 1;
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
            x = xP;
            p = xD;
            left = right = null;
        }
    }

    public Node root = null;

    public void insert(Priority p, Process q, Comparator c) {
        root = insertNode(p, q, c);
    }

    private Node insertNode(Priority p, Process q, Comparator c) {
        if(root == null) {
            root = new Node(p,q);
        }
        if(c.compare(root, ))

    }


    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.Process.processName);
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        System.out.println("Implementing Linux Scheduler using BST.");
        SchedulerTree x = new SchedulerTree();

        Comparator c = new ByAvg();
        Comparator c2 = new ByMean();
        Priority p1 = new Priority(2, 3);
        Priority p2 = new Priority(4, 5);
        Priority p3 = new Priority(6, 7);

        Process
        x.insert(p1, c);
        x.insert(p2, c);
        x.insert(p3, c);

        x.inorder();
    }

}
