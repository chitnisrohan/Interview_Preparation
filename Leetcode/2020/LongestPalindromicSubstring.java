package LeetCode;

public class LongestPalindromicSubstring {

    int low = 0, maxLength = 0;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            startPalindromeSearch(s,i,i);
            startPalindromeSearch(s,i,i+1);
        }
        return s.substring(low, low + maxLength);
    }

    private void startPalindromeSearch(String s, int j, int k) {
        while(j >= 0 && k <s.length() && s.charAt(j) == s.charAt(k)) {
            j--;k++;
        }
        if (maxLength < k-j-1) {
            low = j+1;
            maxLength = k-j-1;
        }
    }

}
