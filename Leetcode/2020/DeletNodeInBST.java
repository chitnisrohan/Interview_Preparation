package LeetCode;

import apple.laf.JRSUIUtils;

public class DeletNodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(7);
        new DeletNodeInBST().deleteNode(root, 5);
    }

    TreeNode parent = null, nodeToDelete = null;

    /*

    In the recursion, return the replacement node after deleting node with given key.
    capture that new node in either left or right of the parent node depending upon which subtree we are going
    Once the node to be deleted is found, replace the value with next inorder successor and then
    delete that successor node (with is guaranteed to be leaf node)

     */

    public TreeNode deleteNode(TreeNode root, int key) {
        System.out.println("Starting with root : " + root.val + " and key : "+ key);
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right =  deleteNode(root.right, key);
            if (root.right == null) {
                System.out.println("Assigned right child : null" +" to root : " + root.val);
            } else {
                System.out.println("Assigned right child : " + root.right.val +" to root : " + root.val);
            }
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            if (root.left == null) {
                System.out.println("Assigned left child : null" +" to root : " + root.val);
            } else {
                System.out.println("Assigned left child : " + root.left.val +" to root : " + root.val);
            }
        }
        else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            root.val = findNextElementInTree(root.right);
            root.right = deleteNode(root.right, root.val);
            if (root.right == null) {
                System.out.println("ABC Assigned right child : null" +" to root : " + root.val);
            } else {
                System.out.println("ABC Assigned right child : " + root.right.val +" to root : " + root.val);
            }
        }
        System.out.println("Returning root as : " + root.val);
        return root;
    }

    private int findNextElementInTree(TreeNode nodeToDelete) {
        TreeNode right = nodeToDelete;
        while(right.left != null) {
            right = right.left;
        }
        return right.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
