package leetcode;
/*
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
 */

public class SuperPow_372 {
	
	public static void main(String[] args) {
		
	}
	
	public int superPow(int a, int[] b) {
		StringBuilder s = new StringBuilder();
		for (int i : b) {
			s.append(i);
		}
		int power = Integer.parseInt(s.toString());
		return (int)Math.pow(a, power) % 1337;
    }

}
