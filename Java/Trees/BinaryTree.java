
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
        if(n.left == null) {
            return n.key;
        }
        return getMin(n.left);
    }

    int getMax(Node n) {
        if(n.right == null) {
            return n.key;
        }
        return getMax(n.right);
    }

    void display(Node n) {

        if(n != null) {
            System.out.println(n.key);
            display(n.left);
            display(n.right);
        }
    }

    void del(int key) {
        if(root != null)
            root = delNode(root,key);
    }

    Node delNode(Node n, int key) {

        if(n.right == null)
            return n.left;
        if(n.left == null)
            return n.right;

        if(key > n.key)
            n.right = delNode(n.right, key);
        else if(key < n.key)
            n.left = delNode(n.left, key);
        return n;
        
    }

    public static void main(String args[]) {
        System.out.println("BST!");
        BinaryTree x = new BinaryTree();
        x.insert(5);
        x.insert(4);
        x.insert(6);
        x.insert(3);
        x.insert(8);
        x.insert(9);

        x.display(x.root); // Display the tree in preorder.

        System.out.println("After searching for 5 : " + x.search(x.root,5));
        System.out.println("After searching for 21 : " + x.search(x.root,21));
        System.out.println("The minimum is : " + x.getMin(x.root));
        System.out.println("The maximum is : " + x.getMax(x.root));
        x.del(6);
        x.display(x.root);

    }

}
