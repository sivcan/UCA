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
    boolean check(TreeNode a, int min, int max) {
        if(a == null)
            return true;
        if(a.val < min || a.val > max)
            return false;

        return(check(a.left, min, a.val - 1) && check(a.right, a.val + 1, max));
    }

	public int isValidBST(TreeNode a) {
	    if(check(a, Integer.MIN_VALUE, Integer.MAX_VALUE))
	        return 1;
	    else
	        return 0;
	}
}
