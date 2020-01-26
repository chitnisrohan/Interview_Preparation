package LeetCode;

import java.util.*;

public class BrickWall {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,2,2,1}));
        List<List<Integer>> arg = new LinkedList<>();
        arg.add(list);
        list = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,1,2}));
        arg.add(list);
        list = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,3,2}));
        arg.add(list);
        list = new LinkedList<Integer>(Arrays.asList(new Integer[]{2,4}));
        arg.add(list);
        list = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,1,2}));
        arg.add(list);
        list = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,3,1,1}));
        arg.add(list);
        System.out.println(new BrickWall().leastBricks(arg));

    }


    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int k = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                k += wall.get(i).get(j);
                //if (k == n) {break;};
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 1);
                }
            }
        }
        int res = wall.size();
        for (int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        return res;



//        Worked for 90% test cases
//        int n = 0, result = Integer.MAX_VALUE;
//        List<Integer> firstRow = wall.get(0);
//        if (firstRow.size() < 2) {
//            return wall.size();
//        }
//        for (Integer i : firstRow) {
//            n = n + i;
//        }
//        int[][] matrix = new int[wall.size()][n+1];
//        for (int i = 0 ; i < wall.size(); i++) {
//            List<Integer> row = wall.get(i);
//            int j = 0;
//            for (int k = 0; k < row.size(); k++) {
//                int m = 0;
//                while(m < row.get(k)) { m++; j++;}
//                matrix[i][j] = 1;
//            }
//        }
//        for (int j = 1 ; j < n; j++) {
//            int min = 0;
//            for (int i = 0 ; i < wall.size(); i++) {
//                if (matrix[i][j] == 0) {
//                    min++;
//                }
//            }
//            result = Math.min(result, min);
//        }
//
//        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
