package LeetCode;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>(Arrays.asList(new String[]{"a","b","c"}));
        System.out.println(new WordLadder().ladderLength("a", "c", list));
    }



    ///////////////////////          PASSING 9/40 TESTS. REASONABLE SOLUTION           ///////////////



    int minTransformations = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        ladderLengthHelper(beginWord, endWord, wordSet, 0, visited);
        return minTransformations == Integer.MAX_VALUE ? 0 : minTransformations;
    }

    private void ladderLengthHelper(String beginWord, String endWord, Set<String> wordSet, int runningLength, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            minTransformations = Math.min(minTransformations, runningLength);
            return;
        }
        String word = null;
        for (int i = 0; i < beginWord.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                //if (beginWord.charAt(i) != c) {
                    StringBuilder sb = new StringBuilder(beginWord);
                    sb.setCharAt(i, c);
                    word = sb.toString();
                //}
                if (!word.equals(beginWord) && wordSet.contains(word) && !visited.contains(word)) {
                    System.out.println("beginword : "+beginWord + " word : "+word);
                    visited.add(word);
                    ladderLengthHelper(word, endWord, wordSet, runningLength + 1, visited);
                    //word = word.replace(c, beginWord.charAt(i));
                }

            }
        }
    }

}
