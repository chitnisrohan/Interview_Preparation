package LeetCode;

import java.util.*;

public class MostCommonWordNotBanned {

    public static void main(String[] args) {
        System.out.println(new MostCommonWordNotBanned().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String mostCommonWord = null;
        int max = 0;
        for (String s : paragraph.split("[ !?',;.]+")) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (map.get(s) > max) {
                    max = map.get(s);
                    mostCommonWord = s;
                }
            }
        }
        return mostCommonWord;
    }

}
