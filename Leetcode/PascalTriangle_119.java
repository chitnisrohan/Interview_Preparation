package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle_119 {
	public static void main(String[] args) {
		for (Integer i : getRow(3)) {
			System.out.print(i + " ");
		}
	}
	
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0 ; i < rowIndex ; i++) {
        	result = getResult(result);
        }
        return result;
    }
	
	public static List<Integer> getResult(List<Integer> result) {
		List<Integer> a = new ArrayList<>();
		a.add(1);
		for (int i = 0; i < result.size()-1 ; i++) {
			a.add(result.get(i) + result.get(i+1));
		}		
		a.add(1);
		return a;
	}

}
