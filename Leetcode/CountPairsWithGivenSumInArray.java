package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountPairsWithGivenSumInArray {

	public static void main(String[] args) {
		System.out.println(getPairsCount(new int[]{10, 12, 10, 15, -1, 7, 6, 
                5, 4, 2, 1, 1, 1}, 11));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N;
		try {
			N = Integer.parseInt(br.readLine());
	        for(int i = 0 ; i < N ; i++)
	        {
	            int[] sides = new int[3]; 
	            String sidestring = br.readLine();
	        }
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int getPairsCount(int[] nums, int sum) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0 ; i < nums.length ; i++) {
			if (hashMap.containsKey(nums[i])) {
				hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
			} else {
				hashMap.put(nums[i], 1);
			}
		}
		int count = 0;
		for (int i = 0 ; i < nums.length ; i++) { 
			if (hashMap.containsKey(sum - nums[i])) {
				count += hashMap.get(sum - nums[i]);
			}
			if (sum - nums[i] == nums[i])
				count--;
		}
		return count/2;
	}
}
