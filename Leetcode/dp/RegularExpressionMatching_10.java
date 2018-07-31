package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching_10 {

	public static void main(String[] args) {
	}
	
	public boolean isMatch(String s, String p) {
		boolean[][] C = new boolean[s.length()+1][p.length()+1];
        C[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && C[0][i-1]) {
                C[0][i+1] = true;
            }
        }
        
        
        for (int i = 1 ; i < s.length()+1 ; i++) {
        	for (int j = 1 ; j < p.length()+1 ; j++) {
        		if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
        			C[i][j] = C[i-1][j-1];
        		else if (p.charAt(j-1) == '*') {
        			C[i][j] = C[i][j-2];
        			if (p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) {
        				C[i][j] = C[i][j] || C[i-1][j];
        			}
        		} else 
        			C[i][j] = false;
        	}
        }        
        
        return C[s.length()][p.length()];    }
}
