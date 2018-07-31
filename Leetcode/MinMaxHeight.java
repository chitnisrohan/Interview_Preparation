package leetcode;

import java.util.HashMap;
import java.util.Set;

public class MinMaxHeight {
	
	private static HashMap<Integer, Integer> hashMap = new HashMap<>();
	private static int minHeight = Integer.MAX_VALUE;
	private static int maxHeight = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		root.left.left.left = new TreeNode(8);
//		root.left.right.left = new TreeNode(9);
//		root.left.left.right = new TreeNode(10);
//		root.right.right.right = new TreeNode(11);
//		root.left.right.left.left = new TreeNode(12);
//		root.right.left.right = new TreeNode(13);
		
		traverse(root, 1);
		
		Set<Integer> keySet = hashMap.keySet();

		for (Integer key : keySet) {
			System.out.println(key + " : " +hashMap.get(key));
		}
		System.out.println("Min Height : "+minHeight);
		System.out.println("Max Height : "+maxHeight);
	}
	
	public static void traverse(TreeNode node, int height) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			minHeight = Math.min(minHeight, height);
			maxHeight = Math.max(maxHeight, height);
		}
		hashMap.put(node.val, height);
		traverse(node.left, height+1);
		traverse(node.right, height+1);
	}
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
