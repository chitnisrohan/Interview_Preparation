package LeetCode.DP;

public class BestTimeToBuyAndSellStock4 {

    /*

    Say you have an array for which the i-th element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most k transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

     */

    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0)
            return 0;

        /*
            this is an optimization which is same as another problem : Best Time To Buy And Sell Stock II
            k >=  prices.length/2 essentially means yu can do any number of transactions and k does not have any importance.
         */

        if (k >=  prices.length/2) {
            int profit = 0;
            for (int i = 0;i < prices.length - 1; i++) {
                if (prices[i] < prices[i+1]) {
                    profit += prices[i+1] - prices[i];
                }
            }
            return profit;
        }
        int[][] C = new int[k+1][prices.length];

        /*
            Note : both i and j loops start with 1 because this problem has 2 base cases
            1. if you are allowed 0 transactions i.e. k = 0, then you make 0 profit
            2. if you have stock prices for only 1 day, you can make 0 profit even if you are allowed many transactions
         */
        for (int i = 1; i <= k ; i++) {
            int max = -prices[0];
            for (int j = 1; j < prices.length ; j++) {
                C[i][j] = Math.max(prices[j] + max, C[i][j-1]);
                max = Math.max(max, C[i-1][j] - prices[j] );

            }
        }
        return C[k][prices.length-1];
    }


    /////////////////          Easy to understand solution by Tushar Roy           //////////////////////

    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    public int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;

                /*
                Solution above keeps track of max and saves this for loop
                 */

                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
        return T[K][prices.length - 1];
    }

}
