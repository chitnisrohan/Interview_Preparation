package leetcode;

import java.util.HashMap;


/*
 * Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.
 */

public class BinaryTreeTilt {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	private static HashMap<Integer, Integer> hashMap = new HashMap<>();
	private static int sum_left = 0;
	private static int sum_right = 0;
	private static int sum = 0;
	private static int i = 0;
	
	public static void main(String[] args) {
		BinaryTreeTilt p = new BinaryTreeTilt();
		BinaryTreeTilt.TreeNode root = p.new TreeNode(1);
		root.left = p.new TreeNode(2);
		root.right = p.new TreeNode(3);
		root.left.left = p.new TreeNode(4);
		root.right.left = p.new TreeNode(5);
				
		
		findTilt(root);
		int answer = 0;
		for (int j : hashMap.keySet()) {
			System.out.println(j + " : " +hashMap.get(j));
			answer += hashMap.get(j);
		}
		System.out.println(answer);
	}
	
	public static void findTilt(TreeNode root) {
		if (root == null)
			return;
		++i;
		findTiltForNode(root.left);
		sum_left = sum;
		sum = 0;
		findTiltForNode(root.right);
		sum_right = sum;
		hashMap.put(i, Math.abs(sum_left - sum_right));
		sum = 0;
		sum_left = 0;
		sum_right = 0;
		findTilt(root.left);
		findTilt(root.right);
		
    }
	
	public static void findTiltForNode(TreeNode root) {
		if (root == null)
			return;
		sum = sum + root.val;
		findTiltForNode(root.left);
		findTiltForNode(root.right);
	}

}
