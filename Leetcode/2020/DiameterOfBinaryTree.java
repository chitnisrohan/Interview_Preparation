package LeetCode;

public class DiameterOfBinaryTree {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  /*
   diameter of tree will be
   max depth of left subtree + max depth of right subtree + 1

    In the recursion we return depth of either left subtree or right subtree whichever is highest + 1
    so that when we get max depth of left and right subtree, we can calculate the diameter as  Math.max(diameter, left + right)
   */

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
