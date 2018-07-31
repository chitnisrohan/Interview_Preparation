package leetcode;
/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class KthLargestElement_215 {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }
	public static int randomizedSelect(int[] nums, int p, int r, int i) {
		if(p == r) {
			return nums[p];
		}
		int q = randomizedPartition(nums, p, r);
		int k = q-p+1;
		if (i == k)
			return nums[q];
		if (i < k) {
			return randomizedSelect(nums, p, q-1, i);
		} else {
			return randomizedSelect(nums, q+1, r, i-k);
		}
	}
	
	public static int randomizedPartition(int[] nums, int p, int r) {
		int x = nums[r];
		int i = p - 1;
		for (int j = p ; j < r ; j++) {
			if (nums[j] <= x) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[i+1];
		nums[i+1] = nums[r];
		nums[r] = temp;
		return i+1;
	}
}
