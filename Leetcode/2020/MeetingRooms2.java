package LeetCode;

import java.util.*;

public class MeetingRooms2 {


    public int minMeetingRooms(int[][] intervals) {
        // sort intervals in non-descending order of start times
        // Start 1st meeting : insert interval 1 into Queue
        // Start iterating over intervals
        // Keep Queue in non-ascending order of end times so that we can start removing first items from Queue if that meeting is over
        // If meeting not over, add interval to Queue
        // finally return Queue size
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<int[]> queue = new PriorityQueue(new EndIntervalComparator());
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (queue.peek()[1] <= intervals[i][0]) {
                queue.poll();
            } else {
                queue.offer(intervals[i]);
            }
        }
        return queue.size();
    }

    class IntervalComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Integer[] i1 = (Integer[])o1;
            Integer[] i2 = (Integer[])o2;
            return i1[0] - i2[0];
        }
    }

    class EndIntervalComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Integer[] i1 = (Integer[])o1;
            Integer[] i2 = (Integer[])o2;
            return i1[1] - i2[1];
        }
    }
}
