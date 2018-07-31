package leetcode;

public class MajorityElement_169 {

	public int majorityElement(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int num : nums) {
            if (result == num)
                count++;
            else 
                count--;
            if (count == 0) {
                result = num;
                count++;
            }
        }
        return result;
    }
	
}
