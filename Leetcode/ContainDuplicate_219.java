package leetcode;

import java.util.HashMap;

public class ContainDuplicate_219 {
	
	public static void main(String[] args) {
		
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0 ; i < nums.length ; i++) {
			if (hashMap.containsKey(nums[i])) {
				if (Math.abs(i - hashMap.get(nums[i])) <= k) 
					return true;
                hashMap.put(nums[i], i);
			} else {
				hashMap.put(nums[i], i);
			}
		}
		return false;
    }

}
