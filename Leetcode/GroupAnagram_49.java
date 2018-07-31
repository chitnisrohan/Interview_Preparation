package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram_49 {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<Integer>> hashMap = new HashMap<>();
        for (int i = 0 ; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!hashMap.containsKey(s)) 
                hashMap.put(s, new ArrayList<>());  
            List<Integer> lst = hashMap.get(s);
            lst.add(i);
            hashMap.put(s, lst);
        }
        for (String s : hashMap.keySet()) {
            List<String> s1 = new ArrayList<>();
            for (Integer i : hashMap.get(s)) {
                s1.add(strs[i]);
            }
            result.add(s1);
        }
               
        return result;
    }	

}
