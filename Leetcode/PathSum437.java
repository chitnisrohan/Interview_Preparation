package leetcode;
/*
 * ou are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */


public class PathSum437 {
	
	private static int numberOfPaths = 0; 
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		PathSum437 p = new PathSum437();
		PathSum437.TreeNode root = p.new TreeNode(5);
		root.left = p.new TreeNode(4);

		root.right = p.new TreeNode(8);
		root.left.left = p.new TreeNode(11);
//		root.left.right = p.new TreeNode(2);
		root.right.left = p.new TreeNode(13);
		root.right.right = p.new TreeNode(4);
		root.left.left.left = p.new TreeNode(7);
		root.left.left.right = p.new TreeNode(2);
//		root.left.right.right = p.new TreeNode(1);
//		root.left.left.right = p.new TreeNode(10);
		root.right.right.right = p.new TreeNode(1);
		root.right.right.left = p.new TreeNode(5);
//		root.left.right.left.left = p.new TreeNode(12);
//		root.right.left.right = p.new TreeNode(13);

		traverse(root, 22);
//		calculatePaths(root, 8, 8);
		System.out.println(numberOfPaths);

	}
	
	public static void traverse(TreeNode node, int sum) {
		if (node == null) 
			return;
		calculatePaths(node, sum, sum);
		traverse(node.left, sum);
		traverse(node.right, sum);
	}
	
	public static void calculatePaths (TreeNode node, int sum, int originalSum) {
		if (node == null) 
			return;
		if (sum - node.val == 0)
			numberOfPaths++;			
		calculatePaths(node.left, sum - node.val, originalSum);
		calculatePaths(node.right, sum - node.val, originalSum);
		
	}

}

