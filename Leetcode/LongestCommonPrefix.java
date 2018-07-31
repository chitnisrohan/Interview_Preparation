package leetcode;

import java.util.HashMap;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"aca","acba"}));
	}
	
	 public static String longestCommonPrefix(String[] strs) {
		 HashMap<Integer, Character> hashMap = new HashMap<>();
		 for (int i = 0 ; i < strs.length ; i++) {
             if (strs[i].length() == 0) {
                 return "";
             }
			 if (i == 0) {
				 int j = 0;
				 for (char ch : strs[i].toCharArray()) {
					 hashMap.put(j++, ch);
				 }
				 continue;
			 }
			 char[] b = strs[i].toCharArray();
             int m=0;
			 for (; m < b.length ; m++) {
                 if (hashMap.containsKey(m)) {
   				 char n = hashMap.get(m);
				 if (n != b[m]) {
                     break;
				 }
                 }
			 }
             if (hashMap.containsKey(m)) {
                 while(hashMap.containsKey(m))
                     hashMap.remove(m++);
             }
			 
		 }
		 StringBuilder s1 = new StringBuilder();
		 for (Integer k : hashMap.keySet()) {
			 s1.append(hashMap.get(k));
		 }
		 
		 return s1.toString();
	 }

}
