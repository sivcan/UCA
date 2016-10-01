/*
 * Complete the function below.
 */

    public void insert(int key) {
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key) {
        if(root == null)
            return new Node(key);
        if(root.key > key)
            root.left = insertNode(root.left, key);
        if(root.key < key)
            root.right = insertNode(root.right, key);
        root.N = 1 + sizeOf(root.left) + sizeOf(root.right);
        return root;
    }



    Integer findRank(Node root, int key) {
        if(root == null)
            return 0;
        if(root.key == key)
            return sizeOf(root.left);
        if(root.key > key)
            return findRank(root.left, key);
        if(root.key < key)
            return  1 + sizeOf(root.left) + findRank(root.right, key);
        return 0;
    }

    public Integer getRank(int key){
        Integer x = get(key);
        if(x == null)
            return -1;
        return findRank(root, key);
    }
