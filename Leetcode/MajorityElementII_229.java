package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MajorityElementII_229 {
	
	public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(3);
        for (int i = 0; i < nums.length ; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                if (hashMap.size() < 3) {
                    hashMap.put(nums[i], 1);
                } else {
                    hashMap.remove(getLowestKey(hashMap));
                    hashMap.put(nums[i], 1);
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int key : hashMap.keySet()) {
            int count = 0;
            for (int i = 0; i < nums.length ; i++) {
                if (nums[i] == key)    
                    count++;
            }
            if (count > nums.length / 3) {
                result.add(key);
            }
        }
        return result;
    }
    
    public int getLowestKey(HashMap<Integer, Integer> hashMap) {
        int min = Integer.MAX_VALUE;
        int minKey = 0;
        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) < min) {
                min = hashMap.get(i);
                minKey = i;
            }
        }
        return minKey;
    }

}
