package leetcode;

public class SearchInRotatedSortedArray_33 {
	
	public int search(int[] nums, int target) {
        if (nums.length < 1)
            return -1;
        int start=0;
        for (int i = 0 ; i < nums.length-1 ; i++) {
            if(nums[i] > nums[i+1]) {
                start = i + 1;
            }
        }
        int i,j;
        if (nums[nums.length - 1] < target) {
            i = 0;
            j = start - 1;
        } else {
            i = start;
            j = nums.length -1;
        }        
        while(i <= j) {
            int mid = (i+j) / 2;
            if (nums[mid] == target)
                //return (mid+start)%nums.length;
                return mid;
            if (nums[mid] < target)
                i = mid+1;
            else 
                j = mid-1;
        }
        return -1;
    }    

}
