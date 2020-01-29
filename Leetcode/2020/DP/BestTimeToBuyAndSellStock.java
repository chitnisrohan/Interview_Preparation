package LeetCode.DP;

public class BestTimeToBuyAndSellStock {

    /*

    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

     */

    public int maxProfit(int[] prices) {
        if (prices== null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxDiffSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            maxDiffSoFar = Math.max(maxDiffSoFar, prices[i] - min);
        }
        return maxDiffSoFar;
    }

}
