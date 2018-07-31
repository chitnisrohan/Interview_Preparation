package leetcode;

import java.util.Arrays;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
 */

public class ReverseWordsInString_186 {
	
	public static void main(String[] args) {
		char[] s = "the sky is blue".toCharArray();
		reverseWords(s);
		System.out.println(Arrays.toString(s));
	}
	
	public static void reverseWords(char[] s) {
		reverse(s, 0, s.length-1);
		int start = 0;
		for (int i = 0; i < s.length ; i++) {
			if (s[i] == ' ') {
				reverse(s, start , i-1);
				start = i+1;
			}
		}
		reverse(s, start, s.length - 1);
	}
	
	public static void reverse(char[] s, int start, int end) {
		while(start < end) {
			char temp = s[start];			
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
	
	

}
