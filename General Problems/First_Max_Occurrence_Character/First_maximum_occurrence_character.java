package practice_for_fidessa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class First_maximum_occurrence_character {

	public static void main(String[] args) {
		
		String s = "abcadcbcdbcdaca";
		
		int[] c = new int[26];
		String c3 = "abcdefghijklmnopqrstuvwxyz";
		for(char c1 : s.toCharArray())
		{
			c[Character.getNumericValue(c1) - 10] += 1;
		}
		
		int max = 0;
		char maximum_occurrence_character = '0';
		for(char c1 : s.toCharArray())
		{
			if(c[Character.getNumericValue(c1) -10] > max)
			{
				max = c[Character.getNumericValue(c1) -10];
				maximum_occurrence_character = c1;
			}
		}
		System.out.println("Max occurrences : "+max +" Character : " + maximum_occurrence_character);
	}
}
