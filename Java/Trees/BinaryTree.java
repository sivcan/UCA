import java.util.*;
public class BinaryTree {

    class Node {
        int key;
        Node right;
        Node left;

        public Node(int item) {  //This parameterized constructor now overrides the default method of constructor. Thus only this is how const. can be called.
            key = item;
            right = left = null;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int key){
        root = insertNode(root,key);
    }

    Node insertNode(Node n, int key) {
        if(n == null)
        {
            return new Node(key);
        }
        if(n.key == key) {//donot update
        }
        else if(key < n.key) {  //if n.key < key then go to the left side of the tree.
            n.left = insertNode(n.left,key);
        }
        else {          //if n.key > key then go to the right side of the tree.
            n.right = insertNode(n.right, key);
        }
        return n;
    }

    boolean search(Node n, int key) {
        if(n == null) {
            return false;
        }
        if(n.key == key) {
            return true;
        }
        if(n.key > key) {
            search(n.right, key);
        }
        if(n.key < key) {
            search(n.left, key);
        }
        return false;
    }

    int getMin(Node n) {
        if(n.left == null) {  //Gets the minimum value of the tree by reaching the last left-node.
            return n.key;
        }
        return getMin(n.left);
    }

    int getMax(Node n) {  //Gets the maximum value of the tree by reaching the last right-node.
        if(n.right == null) {
            return n.key;
        }
        return getMax(n.right);
    }

    void display(Node n) {

        if(n != null) {  //Inorder traversal, thus also shows the sorted array. (ascending order)
            display(n.left);
            System.out.println(n.key);
            display(n.right);
        }
    }

    void del(int key) {
        if(root != null)
            root = delNode(root,key);
    }

    Node delNode(Node n, int key) { //Function delete the given node.

        if(n.right == null)
            return n.left;
        if(n.left == null)
            return n.right;

        if(key > n.key)
            n.right = delNode(n.right, key);

        else if(key < n.key)
            n.left = delNode(n.left, key);

        else {                                          //Node found, time to delete it!

            if(n.left == null)  //Node with 1 child on the right
                return n.right;

            else if(n.right == null) //Node with 1 child on the left
                return n.left;

             //Node with 2 children.
                n.key = getMin(n.right);
                n.right = delNode(n.right, n.key);
        }
        return n;
    }

    void findCommon(Node root1, Node root2) { //Yet to be completed.
        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<Integer> two = new ArrayList<Integer>();

    }

    public static void main(String args[]) {
        System.out.println("BST!");
        BinaryTree x = new BinaryTree();
        // {20,8,22,4,12,10,14}
        x.insert(10);
        x.insert(7);
        x.insert(4);
        x.insert(9);
        x.insert(20);
        x.display(x.root); // Inorder tree traversal.

        //The lines of code down below work. Uncomment them to test the code.
        
        // System.out.println("After searching for 5 : " + x.search(x.root,60));
        // System.out.println("After searching for 21 : " + x.search(x.root,229));
        // System.out.println("The minimum is : " + x.getMin(x.root));
        // System.out.println("The maximum is : " + x.getMax(x.root));
        //
        //
        // System.out.println("After deleting 20 : ");
        // x.del(20);
        // x.display(x.root);
        //
        // System.out.println("After deleting 30 : ");
        // x.del(30);
        // x.display(x.root);
        //
        // System.out.println("After deleting 50 : ");
        // x.del(50);
        // x.display(x.root);
        System.out.println("Second tree : "); // Find the common nodes in between the trees.
        BinaryTree y = new BinaryTree();
        y.insert(5);
        y.insert(1);
        y.insert(10);
        y.insert(7);
        y.insert(9);
        y.insert(4);
        y.insert(7);
        y.insert(0);
        y.display(y.root);
        x.findCommon(x.root, y.root);
    }
}
