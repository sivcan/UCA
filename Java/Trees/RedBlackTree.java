import java.util.*;
public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {

        private int key;
        private Node right;
        private Node left;
        private boolean color;

        public Node(int item, boolean color) {
            this.key = item;
            this.color = color;
            right = left = null;
        }
    }

    private Node root;

    RedBlackTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertNode(root, key);
        root.color = BLACK; //very imp. We don't care what's going on below, we always keep the root as a black node.
    }

    private Node insertNode(Node x, int key) {
        //insertion in tree
        if(x == null) {
            return new Node(key, RED); //New node is always RED.
        }
        if(key < x.key) {
            x.left = insertNode(x.left, key);
        }
        else if (key > x.key){
            x.right = insertNode(x.right, key);
        }
        else {
            x.key = key;
        }

         //Balancing the tree
        if(!isRed(x.left) && isRed(x.right)) x = rotateLeft(x); //If left is not red and right is RED thus we rotate left.
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x); // 4 temporary node, need to rotate it right to balance.
        if(isRed(x.left) && isRed(x.right)) flipColors(x); //Flip colors thus split the temorary node.

        return x;
    }


    private Node rotateLeft(Node x) {
        Node h = x.right;
        x.right = h.left;
        h.left = x;

        h.color = x.color;
        x.color = RED;

        return h;
    }

    private Node rotateRight(Node x) {
        Node h = x.left;
        x.left = h.right;
        h.right = x;

        h.color = x.color;
        x.color = RED;

        return h;
    }

    private boolean isRed(Node x) {
        return x == null ? false : x.color  == RED;
    }

    private void flipColors(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    public void display() {
        inOrder(root);
    }

    private void inOrder(Node x) {

        if(x != null) {

            inOrder(x.left);
            System.out.println(x.key + " ");
            inOrder(x.right);
        }
    }


    public static void main(String args[]) {
        RedBlackTree x = new RedBlackTree();
        x.insert(7);
        x.insert(21);
        x.insert(3);
        x.insert(5);
        x.insert(4);
        x.insert(1);
        x.insert(13);

        x.display();
    }
}
