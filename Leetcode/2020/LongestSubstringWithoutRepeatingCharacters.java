package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLength = 0;
        while(r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r))+1);
                //l = map.get(s.charAt(r))+1; fails for "abba"
            }
            map.put(s.charAt(r), r);
            r++;
            maxLength = Math.max(maxLength, r-l);
        }
        return maxLength;
    }

}
