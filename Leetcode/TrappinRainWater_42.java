package leetcode;

public class TrappinRainWater_42 {

	public int trap(int[] height) {
        int maxSoFarLeft = 0;
        int maxSoFarRight = 0;
        int[] maxOnLeft = new int[height.length];
        int[] maxOnRight = new int[height.length];
        
        for (int i = 0; i < height.length ; i++) {
            if (height[i] > maxSoFarLeft) {
                maxOnLeft[i] = height[i];
                maxSoFarLeft = height[i];
            } else {
                maxOnLeft[i] = maxSoFarLeft;
            }
        }
        
        for (int i = height.length - 1; i >= 0 ; i--) {
            if (height[i] > maxSoFarRight) {
                maxOnRight[i] = height[i];
                maxSoFarRight = height[i];
            } else {
                maxOnRight[i] = maxSoFarRight;
            }
        }
        int totalRainWater = 0;
        for (int i = 0; i < height.length ; i++) { 
            totalRainWater += Math.min(maxOnLeft[i], maxOnRight[i]) - height[i];
        }
        return totalRainWater;
        
    }
}
