package LeetCode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int pivot = 0;
        if (nums.length < 1)
            return -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                pivot = i;
                break;
            }
        }
        int index = binarySearch(nums, target, 0, pivot);
        if (index == -1 && (pivot+1 <= nums.length-1)) {
            index = binarySearch(nums, target, pivot+1, nums.length-1);
        }
        return index;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int mid = (right + left) / 2;
        if (right < left) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid+1, right);
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid-1);
        }
        return -1;
    }
}
