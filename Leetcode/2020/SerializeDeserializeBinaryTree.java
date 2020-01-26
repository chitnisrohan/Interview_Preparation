package LeetCode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    // Level order traversal and store null as left OR right child if they are null


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        System.out.println(new SerializeDeserializeBinaryTree().serialize(root));
        TreeNode root2 = new SerializeDeserializeBinaryTree().deserialize(new SerializeDeserializeBinaryTree().serialize(root));
        System.out.println(new SerializeDeserializeBinaryTree().serialize(root2));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        char COMMA = ',';
        if (root == null) {
            return "";
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode[] nodes = new TreeNode[queue.size()];
            int i = 0;
            while(!queue.isEmpty()) {
                TreeNode n = queue.poll();
                nodes[i++] = n;
                if (n == null) {
                    result.append("null").append(COMMA);
                } else {
                    result.append(n.val).append(COMMA);
                }
            }
            i = 0;
            while(i < nodes.length) {
                if (nodes[i] != null) {
                    queue.offer(nodes[i].left);
                    queue.offer(nodes[i].right);
                }
                i++;
            }

        }
        return result.deleteCharAt(result.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        int level = 0;
        while(i < arr.length) {
            int j = 0;
            while(j < Math.pow(2, level) && i < arr.length) {
                TreeNode node = queue.poll();
                String left = arr[i++];
                String right = arr[i++];
                if (!"null".equals(left)) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(node.left);
                }
                if (!"null".equals(right)) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(node.right);
                }
                j++;
            }
            level++;
            //i++;
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
