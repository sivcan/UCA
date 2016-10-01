import java.util.*;
//Java implementation for the TrieTree.
//Functions : Insertion and Searching
//Pending : Deletion

class TrieTree {

    public TrieTree()  {
        root = new TrieNode();
    }

    TrieNode root;
    private class TrieNode {
        Integer value;
        TrieNode[] nodes = new TrieNode[26];
    }

    void insert(String w, Integer v){
        TrieNode p = root;
        for(int i =0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            if(p.nodes[index] == null) {
                p.nodes[index] = new TrieNode();
            }

            p = p.nodes[index];
        }
        p.value = v;
    }

    public boolean search(String w) {
        return searchString(w);
    }

    private boolean searchString(String w) {
        TrieNode p = root;
        for(int i = 0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            if(p.nodes[index] == null)
                return false;
            p = p.nodes[index];
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("Trie Tree Implementation!");
        TrieTree x = new TrieTree();
        x.insert("slumberjack", 10);
        x.insert("hellberg", 7);
        x.insert("garrix", 3);


        boolean res; //Succesffuly implemented search.
        res = x.search("sivcan"); //Sucessful tests conducted.
        System.out.println(res != false ? "Found!" : "Not Found!");

        res = x.search("hellberg");
        System.out.println(res != false ? "Found!" : "Not Found!");

        res = x.search("garrix"); //Sucessful tests conducted.
        System.out.println(res != false ? "Found!" : "Not Found!");

    }
}
