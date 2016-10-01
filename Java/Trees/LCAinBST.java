import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class Node{
        int key;
        Node left;
        Node right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node originalx;

    Node root;
    Solution() {
        root = null;
    }

    void insert(int item) {
        root = insertNode(root, item);
    }

    Node insertNode(Node root, int item) {
        if(root == null)
            return new Node(item);
        if(root.key < item)
             root.right = insertNode(root.right, item);
        if(root.key > item)
             root.left = insertNode(root.left, item);
        return root;
    }

    Node parent(Node root, Node node) {
        if(root == null)
            return null;
        if(root.left == node || root.right == node)
            return root;
        parent(root.left, node);
        parent(root.right, node);

        return null;
    }

    Node search(Node root, int val1, int val2) {
        if(root == null)
            return null;

        if(root.key == val1 || root.key == val2)
            return parent(originalx, root);
        else {
            if(root.key > val1 && root.key > val2)
                return search(root.left, val1, val2);
            if(root.key < val1 && root.key < val2)
                return search(root.right, val1, val2);
            if(root.key > val1 && root.key < val2  || root.key > val2 && root.key < val1)
                return root;
        }
        return null;
    }

    boolean findVal(Node root, int val) {
        if(root == null)
             return false;
        if(root.key == val)
             return true;
        return(findVal(root.left, val) || findVal(root.right, val));
    }

    void find(int val1, int val2) {
        if(!findVal(root, val1) || !findVal(root, val2)) {
            System.out.println(-1);
            return;
        }
        Node x = search(root, val1, val2);
        if(x == null)
            System.out.println(-1);
        else
            System.out.println(x.key);
    }

    public static void main(String args[] ) throws Exception {
        Solution x = new Solution();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            x.insert(scan.nextInt());
        }
        x.originalx = x.root;
        int q = scan.nextInt();
        for(int i = 0; i < q; i++) {
            int val1 = scan.nextInt();
            int val2 = scan.nextInt();
            x.find(val1, val2);
        }
    }
}
