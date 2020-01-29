package LeetCode.DP;

public class MaximumSubArray {


    /*

        we start adding numbers in the array and keep track of maximum sum.
        as we are keeping track of max sum, we dont care even if it decreases further due to a negative number

     */

    public static void main(String[] args) {
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{1,2,3,-2,5,6,7, -23, 10,10,1}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int maxSumTillNow=Integer.MIN_VALUE;

        for (int i = 0; i < nums.length ; i++) {
            maxSum = nums[i] + maxSum;
            if (maxSum > maxSumTillNow) {
                maxSumTillNow = maxSum;
            }
            // if the running sum goes below zero, we need to reset it to zero. so that it can check if there is any other max sum subarray present going ahead.
            if (maxSum < 0)
                maxSum = 0;
        }
        return maxSumTillNow;
    }
}
