package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderPreorder_105 {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            hashMap.put(inorder[i], i);
        }
        return getTree(hashMap, inorder, preorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode getTree(HashMap<Integer, Integer> hashMap,int[] inorder,int[] preorder,int index,int start,int end) {
        if (index >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = hashMap.get(preorder[index]);
        root.left = getTree(hashMap, inorder, preorder, index + 1, start, rootIndex - 1);
        root.right = getTree(hashMap, inorder, preorder, index + rootIndex - start + 1, rootIndex + 1, end);
        return root;
    }

}
