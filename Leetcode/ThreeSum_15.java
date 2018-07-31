package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * 
 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

public class ThreeSum_15 {
	public static void main(String[] args) {
		Set<List> a = new HashSet<>();
		List<Integer> l1 = new ArrayList();
		List<Integer> l2 = new ArrayList();
		l1.add(1);
		l1.add(0);
		l1.add(-1);
		l2.add(2);
		l2.add(0);
		l2.add(-1);

		a.add(l1);
		a.add(l2);
		
		threeSum(new int[]{-1, 0, 1, 2, -1, -4});
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length - 2 ; i++) {
        	if (i > 0 && nums[i] == nums[i-1])
        		continue;
        	int j = i + 1 , k = nums.length - 1;
        	while(j < k) {
        		if (nums[i] + nums[j] + nums[k] == 0) {
        			result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			while(nums[j] == nums[j+1]) j++;
        			while(nums[k] == nums[k-1]) k--;
        			j++;k--;
        		} else if (nums[i] + nums[j] + nums[k] > 0) {
        			k--;
        		} else {
        			j++;
        		}
        	}
        }
        
        for (List<Integer> l : result) {
        	System.out.println(l);
        }
//        List<List<Integer>> c = new ArrayList<>(a);
//        return a;
        return result;
    }

}
