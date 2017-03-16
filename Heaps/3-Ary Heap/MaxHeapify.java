package heaps;

import java.util.Arrays;

public class MaxHeapify {

	public static void main(String[] args) {
		
		int[] A = {4,3,1,11,7,9,14,2,8,10,16};		
		
		// Build 3 - Ary Max-Heap
		A = build_max_heap(A);
		System.out.println(Arrays.toString(A));
	}
	
	public static int[] build_max_heap(int[] A) {
		for (int i = A.length / 3 ; i >= 0 ; i--) {
			max_heapify(A, i);
		}
		return A;
	}

	public static void max_heapify(int[] A, int i)
	{
		int left = get_leftmost_index(A,i);
		int right = get_rightmost_index(A,i);
		int largest=i;
		for(int k = left; k <= right; k++)
		{
			if(A[k] > A[i] && A[k] > A[largest])
				largest = k;
		}
		if(largest != i)
		{
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			if (isLeaf(A,largest))
				return;
			max_heapify(A,largest);
		}
	}
	
	public static boolean isLeaf(int[] a,int i)
	{
		return i > (a.length / 2);
	}
	
	public static int get_leftmost_index(int[]a, int i)
	{
		int j = 3 * i + 1;
		if(j < a.length)
			return j;
		else 
			return a.length - 1;
	}
	
	public static int get_rightmost_index(int[] a, int i)
	{
		int j = 3 * i + 3;
		if(j < a.length)
			return j;
		else 
			return a.length - 1;
	}
}
