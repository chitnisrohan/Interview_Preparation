package leetcode;

public class BestTimeToBuySellStock_122 {

	public static void main(String[] args) {
		
	}
	
	public int maxProfit(int[] prices) {
        int minimumTillNow = Integer.MAX_VALUE, maxDiffTillNow = Integer.MIN_VALUE;
        for (int i = 0 ; i < prices.length ; i++) {
        	if (prices[i] < minimumTillNow)
        		minimumTillNow = prices[i];
        	if (prices[i] - minimumTillNow > maxDiffTillNow)
        		maxDiffTillNow = prices[i] - minimumTillNow;
        }
        return maxDiffTillNow;
    }
}
