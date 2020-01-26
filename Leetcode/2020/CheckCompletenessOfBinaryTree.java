package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        new CheckCompletenessOfBinaryTree().isCompleteTree(root);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //////////////////////      working solution         /////////////////////////

    /*
    For a complete binary tree, there should not be any node after we met a null node in the final level

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while(!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
    */




    //////////////////////         Solution 2           /////////////////////
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list = levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                while (i < list.size() && list.get(i) == null) {
                    i++;
                }
                return i == list.size();
            }
        }
        return false;
    }

    private List<TreeNode> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> list;
        List<TreeNode> list2 = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            list = new LinkedList<>();
            while (!q.isEmpty()) {
                list.add(q.poll());
            }
            list2.addAll(list);
            for (TreeNode node : list) {
                if (node != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }
        return list2;
    }
}
