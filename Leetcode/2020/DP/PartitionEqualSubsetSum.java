package LeetCode.DP;

public class PartitionEqualSubsetSum {

    /*
    Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not.
    Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
    If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.

    Base case: dp[0][0] is true; (zero number consists of sum 0 is true)

    Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements has made it to j,
    dp[i][j] would also make it to j (we can just ignore nums[i]). If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]],
    which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers.
    Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0;i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int subsetSum = sum/2;
        boolean[][] dp = new boolean[nums.length + 1][subsetSum + 1];

        dp[0][0] = true;
        for (int i = 1;i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1;i <= subsetSum; i++) {
            dp[0][subsetSum] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= subsetSum; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][subsetSum];
    }

}
