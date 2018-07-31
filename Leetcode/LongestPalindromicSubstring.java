package leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		obj.longestPalindrome("ccabb");
	}
	
	public String longestPalindrome(String s) { 
		int[] max = new int[s.length()];
		int maxValue = 0;
		int maxIndex = 0;
		max[0] = 1;
		for (int i = 1 ; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				max[i] = max[i-1] + 1;
			} else {
				if (i - 1 - max[i - 1] > 0) {
					if (s.charAt(i - 1 - max[i - 1]) == s.charAt(i) )
						max[i] = max[i-1] + max[i - 1 - max[i - 1]] + 1;
					else 
						max[i] = max[i-1];						
				}
			else 
				max[i] = max[i-1];
			}
			if(maxValue < max[i]) {
				maxValue = max[i];
				maxIndex = i;
			}
		}
		
		System.out.println(Arrays.toString(max));
		String answer = s.substring(maxIndex-maxValue+1, maxIndex+1);
		System.out.println(answer);
		return "";
	}

}
