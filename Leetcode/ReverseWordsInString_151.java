package leetcode;

public class ReverseWordsInString_151 {
	
	public static void main(String[] args) {
		reverseWords("the sky is blue");
	}
	
	public static String reverseWords(String s) {
		StringBuilder s1 = new StringBuilder(s).reverse();
		int i = 0, start = 0;
		StringBuilder s2 = new StringBuilder();
		while(i < s1.length()) {
			if (s1.charAt(i) == ' ') {
				s2.append(new StringBuilder(s1.substring(start, i)).reverse());
				s2.append(" ");
				start = i+1;
			}
			i++;
		}		
		s2.append(new StringBuilder(s1.substring(start, i)).reverse());
		return s2.toString();
    }

}
