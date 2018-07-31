package leetcode;

public class ReshapeMatrix_566 {
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = 0, col = 0;
        int[][] result = new int[r][c];
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = 0 ; j < nums[0].length ; j++) {
                if (col == c) {
                    col = 0;
                    row++;                    
                }    
                if (row == r) 
                    break;
                result[row][col++] = nums[i][j];

            }
        }
        if (row == r-1 && col == c || row == r && col == c-1) 
            return result;
        else 
            return nums;
    }

}
