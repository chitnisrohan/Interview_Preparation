package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverseFlag = false;
        while(!queue.isEmpty()) {
            List<TreeNode> nodes = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                nodes.add(node);
                list.add(node.val);
            }
            if (reverseFlag) {
                Collections.reverse(list);
            }
            reverseFlag = !reverseFlag;
            result.add(list);
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
