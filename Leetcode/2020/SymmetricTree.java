package LeetCode;

import java.util.Stack;

public class SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //////////////////////            recursive          /////////////////////////
    /*
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root, root);
    }

    private boolean isSymmetricHelper(TreeNode r1, TreeNode r2) {
        if (r1 ==null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val && isSymmetricHelper(r1.left, r2.right) && isSymmetricHelper(r1.right, r2.left);
    }
    */



    //////////////////////            iterative            ///////////////////////

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

}
