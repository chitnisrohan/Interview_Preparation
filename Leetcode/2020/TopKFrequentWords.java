package LeetCode;

import java.util.*;

public class TopKFrequentWords {

    //////////////////////////////////////////////////       Soluion 1       ////////////////////////////////
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        TreeMap<Integer, List<String>> treeMap = new TreeMap(new MyComparator());
        for (String word : map.keySet()) {
            if (!treeMap.containsKey(map.get(word))) {
                treeMap.put(map.get(word), new LinkedList());
            }
            List<String> temp = treeMap.get(map.get(word));
            temp.add(word);
            treeMap.put(map.get(word), temp);
        }
        List<String> result = new LinkedList();
        for (int i = 0; i < k;) {
            List<String> lst = treeMap.get(treeMap.firstKey());
            Collections.sort(lst);
            result.addAll(lst);
            i += lst.size();
            treeMap.remove(treeMap.firstKey());
        }

        return result.subList(0,k);
    }

    class MyComparator implements Comparator {
        @Override
        public int compare(Object i1, Object i2) {
            return (int)i2-(int)i1;
        }
    }


    //////////////////////////////////////////////////       Soluion 2       ////////////////////////////////
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        List<String> result = new LinkedList<>(map.keySet());
        Collections.sort(result, (w1, w2) ->
                map.get(w1) == map.get(w2) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return result.subList(0,k);

    }
}
