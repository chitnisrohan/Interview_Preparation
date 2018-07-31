package leetcode.dp;

import java.util.List;

public class WordBreak_139 {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] C = new boolean[s.length() + 1];
        C[0] = true;
        for (int i = 1 ; i <= s.length() ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (C[j] && wordDict.contains(s.substring(j,i))) {
                    C[i] = true;
                    break;
                }
            }
        }
        return C[s.length()];
    }

}
