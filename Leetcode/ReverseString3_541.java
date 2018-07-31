package leetcode;

/*
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
 * counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and 
 * left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
 */
public class ReverseString3_541 {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}
	
	public static String reverseStr(String s, int k) {
		StringBuilder s1 = new StringBuilder("");
		int i = 0;
		while(i < s.length()) {
			if (i + 2*k - 1 < s.length()) {
				s1.append(new StringBuilder(s.substring(i, i+k)).reverse());
				s1.append(new StringBuilder(s.substring(i+k, i+2*k)));
				i = i + 2*k;
			} else if (i + 2*k > s.length() && i + k < s.length()) {
				s1.append(new StringBuilder(s.substring(i, i+k)).reverse());
				s1.append(new StringBuilder(s.substring(i+k)));
				break;
			} else {
				s1.append(new StringBuilder(s.substring(i)).reverse());
				break;
			}
		}
		return s1.toString();
	}
}
