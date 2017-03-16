package greedy;

public class Min_No_Of_Coins {

	public static void main(String[] args) {

		// Denominations Array
		int[] A = {25, 10, 5, 1};
		int number_of_coins = get_no_of_coins(A, 0, 56, 0);
		System.out.println(number_of_coins);		
	}
	
	public static int get_no_of_coins(int[] A, int i, int n, int number_of_coins)
	{
		number_of_coins += n / A[i];
		int remainder = n % A[i];
		if(remainder == 0)
		{
			return number_of_coins;
		}
		else
		{
			number_of_coins = get_no_of_coins(A, i + 1, remainder, number_of_coins);
			return number_of_coins;
		}
	}

}
