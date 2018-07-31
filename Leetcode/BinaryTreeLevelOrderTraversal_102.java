package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		// push root to Q
		// while q not empty
		// 		while q not empty
		//			pull all from q and add to list
		//      add list to result
		//      for every node in list
		//      	push all their children to q
		// return result
		
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(root);
	    while(!q.isEmpty()) {
	    	List<TreeNode> list = new ArrayList<>();
	    	List<Integer> l1 = new ArrayList<>();
	    	while(!q.isEmpty()) {
	    		TreeNode t = q.poll();
	    		list.add(t);
	    		l1.add(t.val);
	    	}
	    	result.add(l1);
	    	for (TreeNode t : list) {
	    		if (t.left != null) 
	    			q.offer(t.left);
               	if (t.right != null) 
	    			q.offer(t.right);
	    	}
	    }
	    return result;
    }
}
