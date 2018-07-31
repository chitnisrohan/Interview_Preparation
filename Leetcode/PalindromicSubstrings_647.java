package leetcode;

public class PalindromicSubstrings_647 {
	
	public int countSubstrings(String s) {
        int n = s.length();
        int[][] A = new int[n][n];     
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i == j) {
                    A[i][j] = 1;
                    continue;
                } else if (j == i+1 && s.charAt(i) == s.charAt(j)) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        for (int l = 2 ; l < n ; l++) {
            for (int i = 0 ; i < n-l ; i++) {
                int j = i + l;
                if (A[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j))
                    A[i][j] = 1;
                else 
                    A[i][j] = 0;
            }
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                count += A[i][j];
            }
        }
        return count;
    }

}
