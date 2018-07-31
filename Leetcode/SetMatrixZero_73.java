package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero_73 {
	
	public void setZeroes(int[][] matrix) {
		
		// another efficient solution - record zero at position i,j at 0,j and i,0 position
		// and if at row 0 or column 0 we have zero record it in separate 2 boolean variables row and col
		// traverse again (from index 1) and make entire row 0 if there is 0 at i,0 same for column
		// make 0th row and 0th col depending upon varaibles row and col
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0 ; i < matrix.length ; i++ ) {
            for (int j = 0 ; j < matrix[0].length ; j++ ) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (Integer i : rows) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                matrix[i][j] = 0;
            }
        }
        
        for (Integer j : cols) {
            for (int i = 0 ; i < matrix.length ; i++) {
                matrix[i][j] = 0;
            }
        }        
    }
	
	public void anotherSol(int[][] matrix) {
		boolean fr = false,fc = false;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            if(matrix[i][j] == 0) {
	                if(i == 0) fr = true;
	                if(j == 0) fc = true;
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    if(fr) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	    }
	    if(fc) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	    }

	}
	

}
