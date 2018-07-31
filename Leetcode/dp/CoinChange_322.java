package leetcode.dp;

import java.util.Arrays;

public class CoinChange_322 {
	public static void main(String[] args) {
		
	}
	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
            return 0;
        int[] C = new int[amount+1]; 
        Arrays.sort(coins);
        for (int p = 0 ; p <= amount ; p++) {
            C[p] = -1;
        }
        C[0] = 0;
        for (int p = 1 ; p <= amount ; p++) {
        	int min = Integer.MAX_VALUE;
        	for (int i = 0 ; i < coins.length ; i++) {
        		if (coins[i] <= p && C[p-coins[i]] != -1) {
        			if ( 1 + C[p-coins[i]] < min) {
        				min = 1 + C[p-coins[i]];
        			}
        		}
        	}
            C[p] = min < Integer.MAX_VALUE ? min : -1;
        }
        return C[amount] == 0 ? -1 : C[amount];
    }

}
