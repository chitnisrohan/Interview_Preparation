package leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInArray_442 {
	
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList();
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] < 0) {
                if (nums[(-1*nums[i])-1] < 0)
                    result.add((-1*nums[i]));
                nums[(-1*nums[i])-1] = nums[(-1*nums[i])-1] * -1;
            }                
            else {
                if (nums[nums[i]-1] < 0)
                    result.add(nums[i]);
                nums[nums[i]-1] = nums[nums[i]-1] * -1;                
            }
        }
        
        return result;
    }

}
