package LeetCode;

public class LowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p, q);
        return result;
    }

    private boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = 0;
        if (lowestCommonAncestorHelper(root.left, p, q)) {
            left++;
        }
        int right = 0;
        if (lowestCommonAncestorHelper(root.right, p, q)) {
            right++;
        }
        int mid = 0;
        if (root == p || root == q) {
            mid++;
        }
        if (left + right + mid >= 2) {
            result = root;
        }
        return (left + right + mid) > 0;
    }

}
