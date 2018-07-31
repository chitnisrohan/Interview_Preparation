package leetcode;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

public class SearchInsertPosition_35 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		System.out.println(searchInsert(nums, 0));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int left=0, right=nums.length-1, mid;		
		if (target < nums[0])
			return 0;
		if (target > nums[nums.length - 1])
			return nums.length;
		
		while(left<right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				right = mid-1;
			else left = mid+1;
		}
        
        if (nums[left] < target)
            return left+1;
        else if (nums[left] == target)
            return left;
        else return left ;
    }
	
}
