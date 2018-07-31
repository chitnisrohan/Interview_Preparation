package leetcode;
/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */

public class RemoveElement_27 {
	
	public int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length - 1;
        int temp;
        while(i < n) {
        	if(nums[i] == val) {
        		temp = nums[n];
        		nums[n] = nums[i];
        		nums[i] = temp;
        		n--;
        	}        	
        	i++;
        }
        return nums.length - n;
    }

}
