package leetcode;

public class TwoSum2_167 {
	public static void main(String[] args) {
		
	}
	
    public static int[] twoSum(int[] numbers, int target) {
    	int i = 0;
    	int n = numbers.length - 1;
    	while(i < n) {
    		int sum = numbers[i] + numbers[n];
    		if (sum == target) {
    			return new int[]{i+1, n+1};
    		} else if (sum < target) {
    			i++;
    		} else {
    			n--;
    		}
    	}
    	return new int[]{i+1, n+1};

    }

}
