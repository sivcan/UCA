class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    BinaryTree(int item) {  //Adding a new node to the top
        root = new Node(item);
    }

    BinaryTree() {  //Constructor to first initialize the root with a null value.
        root = null;
    }

    static void display(Node root) {  //Preorder Traversal of the tree.
        if(root == null)
            return;
        System.out.println(root.key);
        display(root.left);
        display(root.right);
    }

    static void postDisplay(Node root) { //PostOrder Traversal of the tree.
        if(root == null) {
            return;
        }
        postDisplay(root.left);
        postDisplay(root.right);

        System.out.println(root.key);
    }

    static void inDisplay(Node root) { //InOrder Traversal of the tree.
        if(root == null)
            return;
        inDisplay(root.left);
        System.out.println(root.key);
        inDisplay(root.right);
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right  = new Node(7);
        System.out.println("Preorder Traversal : ");
        display(tree.root);

        System.out.println("Postorder Traversal : ");
        postDisplay(tree.root);

        System.out.println("InOrder Traversal :");
        inDisplay(tree.root);
        System.out.println("Done!");
    }
}
