package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

 */

public class TwoSum {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.twoSum(new int[]{2,7,9,11}, 9)));
	}
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
//    	HashMap<Integer, Integer> hashMap = new HashMap<>();
//    	for (int i = 0; i < nums.length ; i++) {
//    		hashMap.put(nums[i], i);
//    	}
//    	for (int i : nums) {
//    		System.out.println(hashMap.get(i));
//    		if (hashMap.containsKey(target - i) && (hashMap.get(i) != hashMap.get(target - i))) {
//    			result[0] = hashMap.get(i);
//    			result[1] = hashMap.get(target - i);
//    			break;
//    		} else {
//    			hashMap.remove(i);
//    		}
//    	}    	
    	
    	int[] nums2 = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(nums);
    	int i = 0;
    	int num1 = 0, num2 = 1;
    	int n = nums.length;
    	while(i < n) {
    		if (nums[i] + nums[n-i-1] == target && (i != n-i-1)) {
    			num1 = nums[i];
    			num2 = nums[n-i-1];
    			break;
    		} else if (nums[i] + nums[n-i-1] < target) {
    			i++;
    		} else {
    			n--;
    		}
    	}
    	int k = 0;
    	for (int j = 0 ; j < nums2.length && k < nums2.length ; j++) {
    		if(nums2[j] == num1) {
    			result[k++] = j;
    		} 
    		if (nums2[j] == num2 && k < nums2.length) {
    			result[k] = j;
    		}
    	}
    	
    	
    	return result;        
    }
}
