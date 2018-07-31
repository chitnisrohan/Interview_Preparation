package leetcode;

import java.util.Arrays;

public class ZeroOneMatrix_542 {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, 
			{1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, 
			{1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, 
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, 
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, 
			{0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, 
			{1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, 
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
		
		System.out.println(Arrays.deepToString(updateMatrix(matrix)));
	}
	
	public static int[][] updateMatrix(int[][] matrix) {
		int[][] output = new int[matrix.length][matrix[0].length];
		for (int i = 0 ; i < matrix.length ; i++) {
			for (int j = 0; j < matrix[0].length ; j++) {
				if(matrix[i][j] == 1)
					output[i][j] = traverse(matrix, i, j, 0);
			}
		}
		return output;
    }
	
	public static int traverse(int[][] nums, int i, int j, int count) {
		int min = Integer.MAX_VALUE;
		int i1 = i, j1 = j;
		while(i > 0 && nums[i][j] != 0) {
			count++;
            i--; 
            if (i == 0 && nums[i][j] != 0)
                count = Integer.MAX_VALUE;             
		}
        if (count > 0) 
		    min = (count < min) ? count : min;
        count = 0;
		i = i1; j = j1;
		while(i < nums.length && nums[i][j] != 0) {
			count++;
            i++;
            if (i == nums.length && nums[i-1][j] != 0)
                count = Integer.MAX_VALUE;
		}
        if (count > 0) 
    		min = (count < min) ? count : min;
        count = 0;
        i = i1; j = j1;
		while(j > 0 && nums[i][j] != 0) {
			count++;
            j--;
            if (j == 0 && nums[i][j] != 0)
                count = Integer.MAX_VALUE;
     	}
        if (count > 0)
    		min = (count < min) ? count : min;
		count = 0;
        i = i1; j = j1;
		while(j < nums[0].length && nums[i][j] != 0) {
			count++;
            j++;
            if (j == nums[0].length && nums[i][j-1] != 0)
                count = Integer.MAX_VALUE;
		}
        if (count > 0)
            min = (count < min) ? count : min;
        return min;
	}
	}

