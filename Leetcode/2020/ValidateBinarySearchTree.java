package LeetCode;

public class ValidateBinarySearchTree {

    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  /*

  The idea is to use Long.MIN_VALUE and Long.MAX_VALUE to take care of edge conditions where root can be Integer.MAX/MIN VALUE

   */

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
    }
}
