package leetcode;

public class CountAndSay_38 {
	
	public String countAndSay(int n) {
        String s="1";
        if (n == 1)
            return s;
        for (int i = 0; i < n-1 ; i++) {
            s = calculateString(s);
        }
        return s;
    }
    public String calculateString(String s) {
        int i = 0;
        StringBuilder s1 = new StringBuilder();
        while(i < s.length()) {
            int count = 1;
            while(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1))
            {
                count++;
                i++;
            }
            s1.append(count);
            s1.append(s.charAt(i));
            i++;
        }
        return s1.toString();
    }

}
