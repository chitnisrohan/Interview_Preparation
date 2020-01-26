package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // working solution with set
    // public int[] intersection(int[] nums1, int[] nums2) {
    // Set<Integer> set = new HashSet();
    // // keep nums1 small so that set space utilization will be less
    // if (nums1.length > nums2.length) {
    // int[] temp = nums1;
    // nums1 = nums2;
    // nums2 = temp;
    // }
    // for (int num : nums1) {
    // set.add(num);
    // }
    // Set<Integer> set2 = new HashSet();
    // for (int num : nums2) {
    // if (set.contains(num)) {
    // set2.add(num);
    // }
    // }
    // return set2.stream()
    // .mapToInt(Integer::intValue)
    // .toArray();
    // }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> set = new HashSet();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
