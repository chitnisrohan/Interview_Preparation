package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

class Tree {
	TreeNode root = null;

	// Prints the tree from root to leaf and from left to right
	static void printUsingQueue(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		StringBuilder nodes_string = new StringBuilder();
		nodes_string.append(root.data + " ");

		while(!q.isEmpty())
		{
			TreeNode t1 = q.poll();
			if(t1.left != null)
			{
				q.add(t1.left);
				nodes_string.append(t1.left.data + " ");
			}
			if(t1.right != null)
			{
				q.add(t1.right);
				nodes_string.append(t1.right.data + " ");
			}
		}
		System.out.println(nodes_string);
	}
	
	
	public static TreeNode insert(TreeNode node, int data)
    {
        if (node == null)
            node = new TreeNode(data);
        else
        {
            if (node.left == null)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);             
        }
        return node;
    }
	
}

class TreeNode {
	int data;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int data)
	{
		this.data = data;
	}
}

public class Traversal_left_to_right {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.left.left = new TreeNode(10);
		root.right.right.right = new TreeNode(11);
		
		Tree.printUsingQueue(root);
	}
}
