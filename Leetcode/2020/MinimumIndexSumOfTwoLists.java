package LeetCode;

import java.util.*;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> result = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);
                if (indexSum < min) {
                    min = indexSum;
                    result = new LinkedList<>();
                    result.add(list2[i]);
                }
                else if (indexSum == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }

}
