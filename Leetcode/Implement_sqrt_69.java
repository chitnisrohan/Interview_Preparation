package leetcode;

public class Implement_sqrt_69 {
	
	public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while(true) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid+1)) 
                    return mid;
                else 
                    left = mid + 1;
            }
        }
        
    }

}
