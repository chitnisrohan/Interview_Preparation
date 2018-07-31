package leetcode;


public class SortCharsByFrequency_451 {
	
	public static void main(String[] args) {
		System.out.println(frequencySort("Aabb"));
	}
	
	public static String frequencySort(String s) {
		StringBuilder s1 = new StringBuilder();
		int[] count = new int[128];
		for (int i = 0 ; i < s.length() ; i++) {
			count[s.charAt(i)] = count[s.charAt(i)] + 1; 
		}
		
		int max=0, maxIndex=0;
		do {
			max = 0;
			for (int i = 0 ; i < count.length; i++) {
				if (count[i] > max) {
					max = count[i];
					maxIndex = i;
				}					
			}
			for (int i = 0 ; i < max ; i++) {
				s1.append((char)maxIndex);
			}			
			count[maxIndex] = -1;			
		}while(max > 0);
        return s1.toString();
    }
	

}
