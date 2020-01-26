package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("aba", 1);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int i =0, j=0,counter=0,len=0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {
            if (!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) == 0) {
                counter++;
            }
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            j++;
            while(counter>k) {
                if (map.get(s.charAt(i)) == 1) {
                    counter--;
                }
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            len = Math.max(len, j-i);
        }
        return len;
    }

    /////////////////////////////              Solution with array             ////////////////////////////////////
    /*
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        int[] map = new int[256];
        int counter = 0;
        int i=0;
        int j=0;
        int len = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map[ch]==0){
                counter++;
            }
            map[ch]++;
            j++;
            // when counter > k, our constraint of having k distinct is violated.
            while(counter>k){
                // now we want to move i to an index where we can start accepting new distinct characters.
                // if we move i to i+1 when ith character is already present more than once from i to j,
                //      then we will not be able to add jth character to our answer as it will still violate k distinct constraint
                // so we need to move i to i+1 such that ith character is not present between i and j indexes.
                // e.g. eceba and k = 2
                // here after 'ece', to add 'b' to answer, we cant move i to c's index. as answer will be 'ceb' which has 3 distinct characters
                char chI = s.charAt(i);
                if(map[chI]==1){
                    counter--;
                }
                map[chI]--;
                i++;
            }
            len = Math.max(len, j-i);
        }
        return len;
    }
    */

}
