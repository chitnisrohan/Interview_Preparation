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
        lcaHelper(root, p, q);
        return result;
    }

    private boolean lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = 0;
        if (lcaHelper(root.left, p, q)) {
            left = 1;
        }
        int right = 0;
        if (lcaHelper(root.right, p, q)) {
            right = 1;
        }
        int mid = 0;
        if (root == p || root == q) {
            mid = 1;
        }
        if ((left + right + mid) > 1) {
            result = root;
        }
        return (left+right+mid) > 0;
    }

}
