package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(7);
        new AllNodesDistanceKInBinaryTree().distanceK(root, root.left, 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<TreeNode, Integer> map = new HashMap();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        populateMap(root, 0);
        List<Integer> result = new LinkedList<>();
        int targetLevel = map.get(target);
        for (Map.Entry e : map.entrySet()) {
            if ((int)e.getValue() == targetLevel+K) {
                result.add(((TreeNode)e.getKey()).val);
            }
        }
        return result;
    }

    private void populateMap(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        map.put(root, level);
        populateMap(root.left, level + 1);
        populateMap(root.right, level + 1);
    }

}
