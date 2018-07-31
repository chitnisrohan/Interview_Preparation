package leetcode;

import java.util.Arrays;

public class ThirdMaximumNumber_414 {

	public static void main(String[] args) {
		
	}
	public int thirdMax(int[] nums) {
		if (nums.length < 3) {
			Arrays.sort(nums);
		return nums[nums.length - 1];
		}

		if (nums.length < 4) {
			Arrays.sort(nums);
            if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
                return nums[nums.length - 1];
			return nums[0];
		}
		int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
		for (int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == max1 || nums[i] == max2 || nums[i] == max3)
                continue;
           
			if (nums[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			} 
            else if (nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			} 
            else if (nums[i] > max3) {
				max3= nums[i];
			}
		}
		return max3==Integer.MIN_VALUE ? max1 : max3;    }
}
