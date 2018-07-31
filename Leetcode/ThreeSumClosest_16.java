package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest_16 {

	public static void main(String[] args) {
		Set<Integer> a = new TreeSet<>();
		a.add(4);
		a.add(2);
		a.add(1);
		a.add(4);
		a.add(9);
		System.out.println(a.toArray()[0]);
		
	}
	
	public int threeSumClosest(int[] nums, int target) {
		Set<Integer> a = new TreeSet<>();
		for (int i = 0 ; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while(j <= k) {
				int intermidiateSum = nums[i] + nums[j] + nums[k] - target;
				a.add(intermidiateSum);
				while(j < nums.length - 1 && nums[j] == nums[j+1]) j++;
				while(k > 0 && nums[k] == nums[k-1]) k--;
				j++;
				k--;
			}
		}
		return (Integer)a.toArray()[0];
    }
}
