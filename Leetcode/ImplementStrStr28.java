package leetcode;

public class ImplementStrStr28 {

	public static void main(String[] args) {
		System.out.println(strStr("abcbdbcd", "bcd"));
	}

	public static int strStr(String haystack, String needle) {
		int j = 0, m, k;
        if (haystack.length() == 0 && needle.length() == 0)
			return 0;
        if (needle.length() == 0 && haystack.length() > 0)
            return 0;
        if (haystack.length() == 0 || needle.length() > haystack.length())
            return -1;
		for (int i = 0 ; i < haystack.length() ; i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				m = i;
				for (k = i; j < needle.length() && k < haystack.length(); k++ ) {
					if ( !(haystack.charAt(k) == needle.charAt(j++))) {
  						j = 0;
						break;
                    }
				}
                if (j == needle.length()) {
                    return m;
                }				
                if (k == haystack.length()-1) return -1;
				j = 0;
			}
 		}
		return -1;      }
}
