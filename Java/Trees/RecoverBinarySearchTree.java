/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    void morrisTraversal(TreeNode root, HashSet<Integer> h) {

        TreeNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        int last = temp.val; //storing the first element of inorder or the minimum number.

        int update = temp.val;
        TreeNode current  = root;
        TreeNode predecessor;
        while(current != null) {

            if(current.left == null) {
                update = current.val;
                current = current.right;
            }
            else { //Left exists.
                predecessor = current.left;
                //Go to the rightmost child of the left subtree of current.
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    update = current.val;
                    current = current.right;
                }

            }

            if(update < last){
                h.add(update);
                h.add(last);
            }
            else {
                last = update;
            }

        }

    }

	public ArrayList<Integer> recoverTree(TreeNode a) {
	    HashSet<Integer> h = new HashSet<>();
	    ArrayList<Integer> x = new ArrayList<>();

	    morrisTraversal(a, h);
	    for(Integer i : h){
	        x.add(i);
	    }
	    int max = Collections.max(x);
	    int min = Collections.min(x);
	    x.clear();
	    x.add(min);
	    x.add(max);
	    return x;
	}
}
