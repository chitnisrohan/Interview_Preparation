package tree_problems;

public class RB_Tree {
	private static final boolean BLACK = true;
	private static final boolean RED = false;
	Node root;
	Node nilNode = new Node(-999999, BLACK);
	
	public RB_Tree() {
		this.root = this.nilNode;
	}
	
	public int getHeight(Node node) {
        if (node == nilNode)
            return -1;
        int leftHeight = getHeight(node.left);
        int righttHeight = getHeight(node.right);
        return Math.max(leftHeight, righttHeight) + 1;
	}
	
	public Node search(Node x, int key) {
		if (x == this.nilNode || key == x.key) {
			return x;
		}
		if (key < x.key) {
			return search(x.left, key);
		}
		else {
			return search(x.right, key);
		}
	}
	
	public Node minimum(Node x) {
		while (x.left != nilNode) {
			x=x.left;
		}
		return x;
	}
	
	public Node maximum(Node x) {
		while (x.right != nilNode) {
			x=x.right;
		}
		return x;
	}
	
	public Node successor(Node x) {
		if (x.right != nilNode) {
			return minimum(x.right);
		}
		Node y = x.parent;
		while (y != nilNode && x == y.right) {
			x = y; 
			y = y.parent;
		}
		return y;
	}
	
	public Node predecessor(Node x) {
		if (x.left != nilNode) {
			return maximum(x.left);
		}
		Node y = x.parent;
		while (y != nilNode && x == y.left) {
			x = y; 
			y = y.parent;
		}
		return y;
	}
	
	public void insert(RB_Tree T, Node z) {
		Node y = T.nilNode;
		Node x = T.root;
		while (x != T.nilNode) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}
			else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == T.nilNode) {
			T.root = z;
		}
		else if (z.key < y.key) {
			y.left = z;
		}
		else {
			y.right = z;
		}
		z.left = T.nilNode;
		z.right = T.nilNode;
		z.color = RED;
		insertFixUp(T, z);
	}
	
	public void insertFixUp(RB_Tree T, Node z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				Node y = z.parent.parent.right;
				if (y.color == RED) {
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else if (z == z.parent.right) {
					z = z.parent;
					leftRotate(T, z);
				} else {
				z.parent.color = BLACK;
				z.parent.parent.color = RED;
				rightRotate(T, z.parent.parent);
				}
			} else {
				Node y = z.parent.parent.left;
				if (y.color == RED) {
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else if (z == z.parent.left) {
					z = z.parent;
					rightRotate(T, z);
				} else {
				z.parent.color = BLACK;
				z.parent.parent.color = RED;
				leftRotate(T, z.parent.parent);
				}
			}
		}
		T.root.color = BLACK;
	}
	
	public void leftRotate(RB_Tree T, Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != T.nilNode) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == T.nilNode) {
			T.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;		
	}
	
	public void rightRotate(RB_Tree T, Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != T.nilNode) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == T.nilNode) {
			T.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;		
	}
	
	public void inorderTraversal (Node x) {
		if (x != null && x.key != nilNode.key) { 
			inorderTraversal(x.left);
			System.out.println(x);
			inorderTraversal(x.right);
		}
	}
	
	public void sort() {
		this.inorderTraversal(this.root);
	}
	
	public void preorderTraversal (Node x) {
		if (x != null && x.key != nilNode.key) {
			System.out.println(x);
			preorderTraversal(x.left);
			preorderTraversal(x.right);
		}
	}

	static class Node {
		Node left;
		Node right;
		Node parent;
		int key;
		boolean color;

		public Node(int key) {
			this.key = key;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
		
		public Node(int key, boolean color) {
			this.key = key;
			this.parent = null;
			this.left = null;
			this.right = null;
			this.color = color;
		}
		
		public String toString() {
			String color = (this.color ? "BLACK" : "RED");
			String leftkey = (this.left.key == -999999 ? "NIL" : "" + this.left.key);
			String rightkey = (this.right.key == -999999 ? "NIL" : "" + this.right.key);
			return "Key : " + this.key + " Color : " + color + " Left Node : " + leftkey
					+ " Right Node : " + rightkey;
		}
	}
	
	public static void main(String[] args) {
		RB_Tree T = new RB_Tree();

		int[] elements = {5,2,3,6,4,1,10,11,12,13,14,15};
		for (int i = 0 ; i < elements.length ; i++) {
			T.insert(T, new Node(elements[i], RED));
		}
		
		System.out.println(T.search(T.root, 3));
		System.out.println("\nMinimum : " + T.minimum(T.root));
		System.out.println("Maximum : " + T.maximum(T.root));

		System.out.println("\nSucessor of " + T.root.left.key + " is " + T.successor(T.root.left).key);
		System.out.println("Sucessor of " + T.root.right.key + " is " + T.successor(T.root.right).key);
		
		System.out.println("\nPredecessor of " + T.root.right.left.key + " is " + T.predecessor(T.root.right.left).key);
		System.out.println("Predecessor of " + T.root.right.key + " is " + T.predecessor(T.root.right).key);
		
		System.out.println("\nSorted Tree :");
		T.sort();
		
		System.out.println("\nHeight of the tree : "+T.getHeight(T.root));
		
	}

}
