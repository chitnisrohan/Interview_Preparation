package leetcode;

public class MaximumAverageSubarrayI_643 {

	public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0]*1.0;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length - k + 1 ; i++) {
            int j = i;
            int sum = 0;
            while(j < nums.length && j < i+k) {
                sum += nums[j];
                j++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum*1.0 / k;
    }
	
	// optimized solution - sliding window
	public double findMaxAverageOptimized(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0]*1.0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i;
        for (i = 0 ; i < k ; i++) {
            sum += nums[i];
        }
        maxSum = Math.max(maxSum, sum);
        for (i = k ; i < nums.length ; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum*1.0 / k;
    }
	
	
}
