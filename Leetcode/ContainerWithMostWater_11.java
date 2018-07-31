package leetcode;

public class ContainerWithMostWater_11 {

	public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int i = 0, j = height.length-1;
        while(i < j) {
            int area = calculateArea(height, i ,j);
            maxWater = (area > maxWater) ? area : maxWater;
            if (height[i] < height[j])
                i++;
            else 
                j--;
        }
        return maxWater;
    }
    
    public int calculateArea(int[] height,int i ,int j) {
        int k = Math.min(height[i],height[j]);
        return k * (j-i);
    }
}
