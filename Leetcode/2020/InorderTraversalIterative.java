package LeetCode;

import java.util.LinkedList;

public class InorderTraversalIterative {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }

}
