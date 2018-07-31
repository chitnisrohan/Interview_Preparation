package leetcode;

/*
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */

public class ReverseWordsInString_557 {
	private static StringBuilder s1 = new StringBuilder("");
	private static StringBuilder s2 = new StringBuilder("");
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == ' ') {
				s2.append(s1.reverse());
				s2.append(" ");
				s1 = new StringBuilder("");
			} else {
				s1.append(s.charAt(i));
			}			
			if (i == s.length() - 1) {
				s2.append(s1.reverse());
			}
			i++;
		}
		System.out.println(s2);
	}
}
