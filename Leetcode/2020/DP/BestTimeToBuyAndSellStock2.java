package LeetCode.DP;

public class BestTimeToBuyAndSellStock2 {

    /*

    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0;i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

}
