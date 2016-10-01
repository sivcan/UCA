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

    TreeNode search(TreeNode root, int val1, int val2) {
        if(root == null)
            return null;

        if(root.val == val1 || root.val == val2)
            return root;

        else {
            TreeNode l = search(root.left, val1, val2);
            TreeNode r = search(root.right, val1, val2);

            if(l != null && r != null)
                return root;
            else if(l != null && r == null)
                return l;
            else if(r != null && l == null)
                return r;
        }
        return null;
    }

    boolean findVal(TreeNode root, int val) {
        if(root == null)
            return false;
        if(root.val == val)
            return true;
        return (findVal(root.left, val) || findVal(root.right, val));  //Could be on the right or the left.
    }

	public int lca(TreeNode a, int val1, int val2) {
	    if(!findVal(a,val1) || !findVal(a,val2))  //If either of the two values are missing.
	        return -1;
	    TreeNode x = search(a, val1, val2);
	    if(x == null)
	        return -1;
	    return x.val;
	}
}
