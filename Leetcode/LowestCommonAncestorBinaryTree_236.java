package leetcode;

public class LowestCommonAncestorBinaryTree_236 {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == p && right == q || left == q && right == p) {
            return root;
        } 
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

}
