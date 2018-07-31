package leetcode.dp;
/*
 *  '?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
 */
public class WildCardMatching_44 {

	public static void main(String[] args) {
		
	}
	public boolean isMatch(String s, String p) {
		if (p.equals("*") || s.equals(p))
            return true;
        boolean[][] C = new boolean[p.length() + 1][s.length() + 1];
        int i = 0;
        while(i < p.length() && p.charAt(i) == '*') {
        	C[i+1][0] = true;
            i++;
        }        
        while(i < p.length()) {
        	C[i+1][0] = false;
            i++;
        }
        for (int j = 1 ; j <= s.length() ; j++) {
        	C[0][j] = false;
        }
        C[0][0] = true;        
        for (int j = 1 ; j <= p.length() ; j++) {
        	for (int k = 1 ; k <= s.length() ; k++) {
        		if (p.charAt(j-1) == s.charAt(k-1) || p.charAt(j-1) == '?')
        			C[j][k] = C[j-1][k-1];
        		else if (p.charAt(j-1) == '*') {
        			C[j][k] = C[j-1][k] || C[j][k-1];
        		} else 
        			C[j][k] = false;
        	}
        }
        return C[p.length()][s.length()];
    }
}
