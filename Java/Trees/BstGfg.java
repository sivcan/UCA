import java.util.*;

public class BstGfg{
    class Node {
        int key;
        Node left;
        Node right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;
    Node succ;
    BstGfg() {
        root = null;
        succ = null;
    }

    void insert(int key) {
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(root.key == key) {
            //Do nothing.
        }

        else if(key  > root.key) {
            succ = root;
            root.right = insertNode(root.right, key);
        }

        else if(key < root.key) {
            root.left = insertNode(root.left, key);
        }
        return root;
    }

    void display(Node root) {

    }

    public static void main(String args[]) {
        System.out.println("Greater on right - Gfg.");
        System.out.println("The link : http://www.geeksforgeeks.org/replace-every-element-with-the-least-greater-element-on-its-right/\n");
        BstGfg x = new BstGfg();
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        for(int i : arr) {
                x.insert(i);
        }

        for(int i : arr) {
            System.out.print(x.search(x.root,i) + " ");
        }
    }
}
