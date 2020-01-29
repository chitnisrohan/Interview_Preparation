package LeetCode.DP;

public class CoinChange {

    /*

    greedy only works for specific combinations of denominations. e.g. indian currency denominations
    it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6.

    thus it needs a DP solution

     */

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= amount; i++) {
            // Integer.MAX_VALUE-1 so that Math.min calculation in the for loop should work
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                // if amount is greater than coin value the we can decide whether including it gives minimum coins or excluding it gives min coins
                // else simply we cant include this coin
                if (j >= coins[i-1]) {
                    // we are not decreasing i in this part below "1 + dp[i][j-coins[i]]" because we have infinite number of coins of same denomination
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : dp[coins.length][amount];
    }
}
