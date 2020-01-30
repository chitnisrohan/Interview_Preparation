package LeetCode.DP;

public class WaysToCoverDistance {

    /*

                    NOT MY SOLUTION

    Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.

     */


    public int printCountDP(int dist)
    {
        int[] count = new int[dist+1];

        // Initialize base values. There is one way to
        // cover 0 and 1 distances and two ways to
        // cover 2 distance
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;

        // Fill the count array in bottom up manner
        for (int i=3; i<=dist; i++)
            count[i] = count[i-1] + count[i-2] + count[i-3];

        return count[dist];
    }
}
