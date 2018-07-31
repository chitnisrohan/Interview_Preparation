package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

	public static void main(String[] args) {
		
	}
	List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        result  = new ArrayList<>();
        String path = new String();
        traverseTree(root, path);        
        return result;
    }
    
    public void traverseTree(TreeNode root,String path) {
        if (root.left == null && root.right == null) {
            path = path + root.val;
            result.add(path);
        }
        path = path + root.val + "->";
        if (root.left != null) {            
            traverseTree(root.left, path);
        }
        if (root.right != null) {
            traverseTree(root.right, path);
        }            
    }
}
