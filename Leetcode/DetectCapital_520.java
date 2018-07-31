package leetcode;

public class DetectCapital_520 {
	
	public boolean detectCapitalUse(String word) {
        int n = word.length(); 
        if (n < 2)
            return true;
        if (word.charAt(0) - 'a' >= 0) 
            return checkIfAllLowerCase(word);
        else if (word.charAt(0) - 'a' < 0 && word.charAt(1) - 'a' >= 0)
            return checkIfOnlyFirstCapital(word);
        else 
            return checkIfAllCapital(word);
    }
    
    public boolean checkIfAllLowerCase(String word) {
        for (char ch : word.toCharArray()) {
            if (ch - 'a' < 0)
                return false;
        }
        return true;
    }
    
    public boolean checkIfOnlyFirstCapital(String word) {
        for (int i = 1; i < word.length() ; i++) {
            if (word.charAt(i) - 'a' < 0)
                return false;
        }
        return true;
    }
    
    public boolean checkIfAllCapital(String word) {
        for (char ch : word.toCharArray()) {
            if (ch - 'a' >= 0)
                return false;
        }
        return true;
    }

}
