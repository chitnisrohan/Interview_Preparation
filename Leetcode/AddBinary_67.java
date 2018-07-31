package leetcode;

import java.util.Arrays;

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class AddBinary_67 {
	
	public static void main(String[] args) {
		addBinary("111", "11");
	}

	public static String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1, remainder = 0;
		char[] ch_a = a.toCharArray();
		char[] ch_b = b.toCharArray();
		StringBuilder output = new StringBuilder("");

		// 0 - 48, 1 - 49
		int m,n,o;
		while(i >= 0 && j >= 0) {
			m = ch_a[i] - 48;
			n = ch_b[j] - 48;
			o = m+n+remainder;
			if(o == 2) {
				o = 0;
				remainder = 1;
			} else if (o == 3) {
				o = 1;
				remainder = 1;
			} else if (o == 1) {
				o = 1;
				remainder = 0;
			} else {
				o = 0;
				remainder = 0;
			}
			output.append(o);
			i--;j--;
		}
		System.out.println(output);
		while(i >= 0) {
			m = ch_a[i] - 48;
			o = m+remainder;			
			if(o == 2) {
				o = 0;
				remainder = 1;
			} else if (o == 1) {
				o = 1;
				remainder = 0;
			} else {
				o = 0;
				remainder = 0;
			}
			output.append(o);
			i--;
		}
		while(j >= 0) {
			n = ch_b[j] - 48;
			o = n+remainder;
			if(o == 2) {
				o = 0;
				remainder = 1;
			} else if (o == 1) {
				o = 1;
				remainder = 0;
			} else {
				o = 0;
				remainder = 0;
			}
			output.append(o);
			j--;
		}
		if (remainder == 1) {
			output.append("1");
		}
		System.out.println(output.reverse());
		return "";
    }
	
}
