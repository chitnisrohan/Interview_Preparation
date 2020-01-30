package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        getPaths(root, sum, result, 0, new ArrayList());
        return result;
    }

    private void getPaths(TreeNode root, int sum, List<List<Integer>> result, int currentSum, List<Integer> currentPath) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (root.left == null && root.right == null && root.val + currentSum == sum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            getPaths(root.left, sum, result, currentSum + root.val, currentPath);
            getPaths(root.right, sum, result, currentSum + root.val, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}