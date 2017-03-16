package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Job_Sequencing {

	public static void main(String[] args) {

		// jobs array structure - job name, deadline, profit
		// each activity takes unit time
		// we want to maximize the profit and schedule maximum possible jobs
		Object[][] jobs = {{'a',2,100},{'b',1,30},{'c',2,27}, {'d',1,25},{'e',4,15}};  
		// more examples
//		Object[][] jobs = {{'a',3,9},{'b',2,7},{'c',3,7}, {'d',1,2}};
//		Object[][] jobs = {{'a',2,50},{'b',1,10},{'c',2,15}, {'d',1,30}};

		int maximum_deadline = (int) jobs[0][1];
		for (int i = 0 ; i < jobs.length ; i++)
			maximum_deadline = Math.max(maximum_deadline, (int)jobs[i][1]);
				
		// sort descending by profit.	
		jobs = merge_sort (jobs);
		
		ArrayList<Character> JobSequence = new ArrayList<>();
		for(int i = maximum_deadline ; i >= 0 ; i--)
		{
			for (int j = 0 ; j < jobs.length ; j++)
			{
				if((int)jobs[j][1] >= i+1)
				{
					if(JobSequence.contains((Character)jobs[j][0]))
						continue;
					JobSequence.add((Character) jobs[j][0]);
					break;
				}
			}
		}		
		Collections.reverse(JobSequence);
		System.out.println(JobSequence.toString());		
	}


	// descending sort
	public static Object[][] merge_sort(Object[][] array)
	{
		if(array.length == 1)
			return array;
		else			
			return merge(merge_sort(Arrays.copyOfRange(array, 0, (array.length/2))), 
				merge_sort(Arrays.copyOfRange(array, array.length/2, array.length)));		
	}
	public static Object[][] merge(Object[][] objects, Object[][] objects2)
	{
		Object[][] merged_array = new Object[objects.length + objects2.length][];
		int k=0;
		for(int i = 0,j = 0 ; k < objects.length+objects2.length ; )
		{
			if((int)objects[i][2] > (int)objects2[j][2])
			{
				merged_array[k++] = objects[i++];
			}
			else if ((int)objects[i][2] < (int)objects2[j][2])
			{
				merged_array[k++] = objects2[j++];
			}
			else
			{
				merged_array[k++] = objects[i++];
				merged_array[k++] = objects2[j++];
			}
			if(i == objects.length)
			{
				while(j < objects2.length)
					merged_array[k++] = objects2[j++];
				break;
			}
			if(j == objects2.length)
			{
				while(i < objects.length)
					merged_array[k++] = objects[i++];
				break;
			}
		}
		return merged_array;
	}
}
