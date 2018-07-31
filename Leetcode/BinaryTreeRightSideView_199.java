package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
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
        List<Integer> output = new ArrayList<>();
        for (List<Integer> lst : result) {
            output.add(lst.get(lst.size() - 1));
        }
	    return output;
    }

}
