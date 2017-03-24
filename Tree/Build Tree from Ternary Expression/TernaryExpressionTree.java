package tree_problems;

public class TernaryExpressionTree {
	
	private TreeNode root;
	
	public TernaryExpressionTree() {
		this.root = null;
	}
	
	static class TreeNode {
		String data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(String data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void addExpression(String s, TreeNode node1) {
		if(!s.contains("?") && !s.contains(":")) {
			node1.right = new TreeNode(s);
			return;
		}
		String[] splitExpr = s.split("\\?");
		TreeNode node = new TreeNode(splitExpr[0]);
		if (node1 == null) {
			this.root = node;
			node1 = node;
		}
		String s2 = s.replaceFirst(splitExpr[0]+"\\?", "");
		node.left = new TreeNode(s2.split(":")[0]);
		node1.right = node;
		addExpression(s2.replaceFirst(s2.split(":")[0] + ":", ""), node);
	}
	
	public void print(TreeNode node) {
		if (node == null)
			return;
		System.out.println(node.data);
		print(node.left);
		print(node.right);
	}

	public static void main(String[] args) {
		String expression = "is 1 less than 5?true:is 1 less than 3?true:is 2 less than 1?false:else true";
		TernaryExpressionTree expressionTree = new TernaryExpressionTree();
		expressionTree.addExpression(expression, expressionTree.root);
		expressionTree.print(expressionTree.root);
	}
}
