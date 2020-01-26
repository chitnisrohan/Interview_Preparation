package LeetCode;

import java.util.*;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    ///////////////////////         WORKS FOR 90/93 TESTS. GETTING TIME LIMIT EXTENDED ERROR           /////////////////

    int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        dfs(root, parentMap);
        parentMap.remove(null);

        for (TreeNode node : parentMap.keySet()) {
            Set<TreeNode> visited = new HashSet<>();
            dfsForPathSum(node, visited, 0, parentMap);
        }
        return maxSum;
    }

    private void dfsForPathSum(TreeNode node, Set<TreeNode> visited, int runningSum, Map<TreeNode, TreeNode> parentMap) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        maxSum = Math.max(maxSum, runningSum + node.val);

        if (node.left != null && !visited.contains(node.left)) {
            dfsForPathSum(node.left, visited, runningSum + node.val, parentMap);
        }
        if (node.right != null && !visited.contains(node.right)) {
            dfsForPathSum(node.right, visited, runningSum + node.val, parentMap);
        }
        if (!visited.contains(parentMap.get(node))) {
            dfsForPathSum(parentMap.get(node), visited, runningSum + node.val, parentMap);
        }
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        parentMap.put(root.left, root);
        parentMap.put(root.right, root);
        dfs(root.left, parentMap);
        dfs(root.right, parentMap);
    }
}
