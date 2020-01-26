package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (result.get(j)[1] >= intervals[i][0]) {
                result.get(j)[1] = Math.max(result.get(j)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
