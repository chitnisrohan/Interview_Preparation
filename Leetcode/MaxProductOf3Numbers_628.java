package leetcode;

public class MaxProductOf3Numbers_628 {
	
	public static void main(String[] args) {
		maximumProduct(new int[]{-4,-2,-3,5,3,60,28,57});
	}

	public static int maximumProduct(int[] nums) {
	    int max1 = Integer.MIN_VALUE;
	    int max2 = Integer.MIN_VALUE;
	    int max3 = Integer.MIN_VALUE;
	    int min1 = Integer.MAX_VALUE;
	    int min2 = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n > max1) {
				max3 = max2;
				max2 = max1;				
				max1 = n;
			} 
			else if (n > max2) {
				max3 = max2;
				max2 = n;
			}
			else if (n > max3) {
				max3 = n;
			}
			if (n < min1) {
				min2 = min1;
				min1 = n;
			}
			else if (n < min2) {
				min2 = n;
			}
		}
		return Math.max(max1*max2*max3, max1* min1*min2);
    }
		
}
