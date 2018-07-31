package leetcode;

public class ValidateBST_98 {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		
	}
	
	private Boolean result = true;
    public boolean isValidBST(TreeNode root) {
    	if (root == null)
			return true;
        if (root.left == null && root.right == null)
            return true;
		int highestOnLeft = findHighest(root.left, Integer.MIN_VALUE);
		int lowestOnRight = findLowest(root.right, Integer.MAX_VALUE);
		if ((root.left != null && root.val <= highestOnLeft) || (root.right != null && root.val >= lowestOnRight))
			return false;
		result = result && isValidBST(root.left);
		result = result && isValidBST(root.right);
		return result;
    }
	
	public static int findHighest(TreeNode root, int x) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.val > x)
			x = root.val;
		int l = findHighest(root.left, x);
		int r = findHighest(root.right, x);
		return Math.max(Math.max(l,r), x);	
	}
	
	public static int findLowest(TreeNode root, int x) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.val < x)
			x = root.val;
		int l = findLowest(root.left, x);
		int r = findLowest(root.right, x);
		return Math.min(Math.min(l,r), x);
	}

	
}


