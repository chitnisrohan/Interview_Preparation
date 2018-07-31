package leetcode.hard;

import java.util.HashMap;

public class MaxPointsOnALine {
	
	public static void main(String[] args) {
		
	}

    public static int maxPoints(Point[] points) {
        int result = 0;
        for (int i = 0 ; i < points.length - 1 ; i++) {
        	int max = 0;
        	int samepointCount = 0;
        	HashMap<Double, Integer> hashMap = new HashMap<>();
        	for (int j = 0 ; j < points.length ; j++) {
        		if (points[i].x == points[j].x && points[i].y == points[j].y)
        			samepointCount++;
        		else if (points[i].x == points[j].x) {
        			hashMap.put((double)Integer.MAX_VALUE, hashMap.get(Integer.MAX_VALUE) + 1);
        		} else {
        			double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x);
        			hashMap.put(slope, hashMap.get(slope) + 1);
        		}
        	}               	
        	for (Double key : hashMap.keySet()) {
        		max = Math.max(max, hashMap.get(key));
        	}
        	hashMap.put((double)max, hashMap.get(max) - samepointCount);
        	result = Math.max(max, result);
        }
        return result;
    }
}


  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 
