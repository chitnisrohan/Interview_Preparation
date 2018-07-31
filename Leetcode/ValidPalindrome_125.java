package leetcode;

public class ValidPalindrome_125 {
	
	public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase(); 
        if (s1.length() < 2)
            return true;
        return s1.equals(new StringBuilder(s1).reverse().toString());
    }

}
