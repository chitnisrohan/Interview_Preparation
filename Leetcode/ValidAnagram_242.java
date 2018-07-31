package leetcode;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram_242 {
	
	public static void main(String[] args) {
		
	}
	public static boolean isAnagram(String s, String t) {
        int[] a = new int[128];
        for (int i = 0; i < s.length() ; i++) {
        	int b = s.charAt(i);
        	a[b] = a[b] + 1;
        }
        for (int i = 0; i < t.length() ; i++) {
        	int b = t.charAt(i);
        	a[b] = a[b] - 1;
        }
        for (int i = 0; i < s.length() ; i++) {
        	if (a[i] != 0)
        		return false;
        }
        return true;
    }

}
