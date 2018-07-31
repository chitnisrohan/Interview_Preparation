package leetcode;

import leetcode.PathSum437.TreeNode;

/*
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */


public class ConstructStringFromBinaryTree {
	
	private static StringBuilder s;
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		s = new StringBuilder("");
		ConstructStringFromBinaryTree p = new ConstructStringFromBinaryTree();
		ConstructStringFromBinaryTree.TreeNode root = p.new TreeNode(1);
		root.left = p.new TreeNode(2);

		root.right = p.new TreeNode(3);
		root.left.left = p.new TreeNode(4);
//		root.left.right = p.new TreeNode(2);
//		root.right.left = p.new TreeNode(13);
//		root.right.right = p.new TreeNode(4);
//		root.left.left.left = p.new TreeNode(7);
//		root.left.left.right = p.new TreeNode(2);
//		root.left.right.right = p.new TreeNode(1);
//		root.left.left.right = p.new TreeNode(10);
//		root.right.right.right = p.new TreeNode(1);
//		root.right.right.left = p.new TreeNode(5);
//		root.left.right.left.left = p.new TreeNode(12);
//		root.right.left.right = p.new TreeNode(13);

//		s.append(root.val);
		tree2str(root);
		s = new StringBuilder(s.toString().replaceAll("left", ""));
		System.out.println(s.substring(1, s.length()-1));		
	}
	
	public static void tree2str(TreeNode t) {
		if (t == null) {
			return;
		}
		if (t.left == null && t.right != null) {
			s.append("(");
			s.append(t.val);
			s.append("()");
			tree2str(t.right);
			s.append(")");
		} else {
			s.append("(");
			s.append(t.val);
			tree2str(t.left);
			tree2str(t.right);
			s.append(")");
		}
    }

}
