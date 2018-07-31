package leetcode;

public class SearchInSortedMatrix_240 {
	
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        for (int i = 0 ; i < matrix.length ; i++) {
	            int start = 0, end = matrix[0].length;
	            //int mid = ( start + end ) / 2;
	            while(start < end) {
	                int mid = ( start + end ) / 2;
	                if (matrix[i][mid] == target)
	                    return true;
	                else if (matrix[i][mid] < target)
	                    start = mid + 1;
	                else 
	                    end = mid;
	            }
	        }
	        return false;
	    }
	
//	 We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
	// efficient solution below -
	public boolean anotherSol(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

}
