package leetcode;

public class MergeSortedArray_88 {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for (int i = 0 ; i < n ; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }            
        if (n == 0) {
            return;
        }
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i >=0 && j>= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }
        if (i < 0) {
            while(j >= 0)
                nums1[k--] = nums2[j--];
            }
    }

}
