package leetcode;

public class BestTimeToBuySellStock_121 {

	public static void main(String[] args) {
		
	}
	
	public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxDiffSoFar = 0;
        for (int i = 0 ; i< prices.length ; i++) {
            if (prices[i] < minSoFar)
                minSoFar = prices[i];
            maxDiffSoFar = Math.max(maxDiffSoFar, prices[i] - minSoFar);
        }
        return maxDiffSoFar;
    }
}
