package leetcode;

public class MaxConsecutiveOnes_485 {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 1) {
                count++;
                max = Math.max(count, max);
            } else 
                count = 0;            
        }
        return Math.max(count, max);
    }

}
