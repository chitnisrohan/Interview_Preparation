package leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MaxSubarray_53 {
	
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
			
	public static int maxSubArray(int[] nums) {
        int maxSum = 0;
        int maxSumTillNow=0;
        
        for (int i = 0; i < nums.length ; i++) {
        	maxSum = nums[i] + maxSum;
        	if (maxSum > maxSumTillNow) {
        		maxSumTillNow = maxSum;
        	}
        	if (maxSum < 0)
        		maxSum = 0;
        }
        return maxSumTillNow;
    }

}
