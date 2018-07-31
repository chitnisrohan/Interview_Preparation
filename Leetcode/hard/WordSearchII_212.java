package leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII_212 {
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
        for (String word : words) {     
            if (word.length() > board.length * board[0].length)
                continue;
        	if (wordInBoard(board, word))
        		result.add(word);
        }
        return new LinkedList<>(result);
    }
	
	private boolean wordInBoard(char[][] board, String word) {
        StringBuilder s = new StringBuilder();
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
                    s = new StringBuilder();
					wordInBoard(board, i, j, word, s, 0, 5);                   
                    if (s.toString().equals(word))
                        return true;
                }
			}
		}	
        return false;
    }

	private void wordInBoard(char[][] board, int i, int j, String word, StringBuilder s, int k, int m) {
        if (s.length() == word.length())
            return;
		if (k < word.length() && i >= 0 && i < board.length && j >= 0 && j < board[i].length && word.charAt(k) == board[i][j]) {
			s.append(word.charAt(k));
            if (i > 0 && m != 0) wordInBoard(board, i-1, j, word, s, k+1, 1);
    		if (i < board.length-1 && m != 1) wordInBoard(board, i+1, j, word, s, k+1, 0);
     		if (j > 0 && m != 3) wordInBoard(board, i, j-1, word, s, k+1, 2);
	    	if (j < board[i].length-1 && m != 2) wordInBoard(board, i, j+1, word, s, k+1, 3);	
			return;
		}
	}

}
