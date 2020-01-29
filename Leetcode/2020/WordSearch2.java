package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    /*

                NOT MY SOLUTION

                https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

    Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

    How do we instantly know the current character is invalid? HashMap?
    How do we instantly know what's the next valid character? LinkedList?
    But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
    Combing them, Trie is the natural choice. Notice that:

    Optimizations :
        TrieNode is all we need. search and startsWith are useless.
        No need to store character at TrieNode. c.next[i] != null is enough.
        Never use c1 + c2 + c3. Use StringBuilder.
        No need to use O(n^2) extra space visited[m][n].
        No need to use StringBuilder. Storing word itself at leaf node is enough.
        No need to use HashSet to de-duplicate. Use "one time search" trie.
     */


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        // there is no word in the dictionary with current prefix
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            // this is an optimization to not find same word again and again
            p.word = null;     // de-duplicate
        }

        // idea is to mark i,j visited for current iteration of DFS
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);

        // tried all possible word searches starting from i,j
        // now backtrack so that other searches should visit i,j
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        // create root for trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            // start every word from root
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
