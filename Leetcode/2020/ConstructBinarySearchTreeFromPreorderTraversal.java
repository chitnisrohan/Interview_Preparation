package LeetCode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBinarySearchTreeFromPreorderTraversal {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOfRange(preorder, 0, preorder.length);
        Arrays.sort(inorder);
        return bstFromInorderPreorder(inorder, preorder);
    }

    private TreeNode bstFromInorderPreorder(int[] inorder, int[] preorder) {
        if (preorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = Arrays.stream(inorder) 					// IntStream
                .boxed()						// Stream<Integer>
                .collect(Collectors.toList())   // List<Integer>
                .indexOf(preorder[0]);
        root.left = bstFromInorderPreorder(Arrays.copyOfRange(inorder, 0, index),
                Arrays.copyOfRange(preorder, 1, index+1));
        root.right = bstFromInorderPreorder(Arrays.copyOfRange(inorder, index+1, inorder.length),
                Arrays.copyOfRange(preorder, index+1, preorder.length));
        return root;
    }

}
