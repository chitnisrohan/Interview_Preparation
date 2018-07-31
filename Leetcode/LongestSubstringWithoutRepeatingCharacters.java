package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int l = 0, r = 0, max = 0;
        if (s.length() == 1)
            return 1;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		while(r < s.length()) {
			if (hashMap.containsKey(s.charAt(r))) {
                
                l = Math.max(l, hashMap.get(s.charAt(r)) + 1) ;
            }
            hashMap.put(s.charAt(r), r);
			
			
            max = (max < r - l + 1) ? r - l + 1 : max;           
            r++;
		}
		return max;
	}
	
}
