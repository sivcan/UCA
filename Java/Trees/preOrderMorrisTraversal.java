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
    void morrisTraversal(TreeNode root, ArrayList<Integer> x) {
        TreeNode current = root;
        TreeNode prev;
        while(current != null) {

            if(current.left == null)  { //if left does not exist.
                x.add(current.val);
                current = current.right;
            }
            else { //left side does exist.
                prev = current.left;
                while(prev.right != null && prev.right != current)
                    prev = prev.right;

                if(prev.right == null) {
                    prev.right = current;
                    x.add(current.val);
                    current = current.left;
                }
                else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }
    }

	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> x = new ArrayList<>();
	    morrisTraversal(a, x);
	    return x;
	}
}
