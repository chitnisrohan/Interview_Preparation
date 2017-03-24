package practice_for_fidessa;

import java.io.*;
import java.util.*;

public class No_of_Platforms {

    public static void main(String[] args) {
   		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    Arrays.sort(arr);
	    Arrays.sort(dep);
	    int [] combined_arr = new int[arr.length * 2];
	    int i = 0, j = 0, k = 0;
	    
	    // if arrival is less add 0
	    // if departure is less add 1
	    while(i < arr.length || j < dep.length)
	    {
	    	if(arr[i] < dep[j])
	    	{
	    		combined_arr[k++] = 0;
	    		i++;
	    	}
	    	else
	    	{
	    		combined_arr[k++] = 1;
	    		j++;
	    	}
			if(i == arr.length)
			{
				while(j < dep.length)
				{
					combined_arr[k++] = 1;
					j++;
				}
				break;
			}
			if(j == dep.length)
			{
				while(i < arr.length)
				{
					combined_arr[k++] = 0;
					i++;
				}
				break;
			}
	    }
	    int platform_count = 0;	    
	    
	    // add platform count on arrival and decrease by 1 (OR make it 0 if its 0) on departure
	    for(i = 0 ; i < combined_arr.length ; i++)
	    {
	    	if(combined_arr[i] == 0)
	    	{
	    		platform_count = (platform_count == 0) ? 0 : platform_count - 1;
	    	}
	    	else
	    		platform_count++;
	    }
	    System.out.println(platform_count);
    }
}
