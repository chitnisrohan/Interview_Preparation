package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class FrogJump {

    // NOT WORKING
    // 35 out of 39 test cases pass

    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<Integer>();
        for( int s : stones) {
            set.add(s);
        }
        return dfs(set, 0, 0, stones[stones.length - 1]);
    }

    private boolean dfs(Set<Integer> set, int distance, int position, int lastStonePosition) {
        if (position == lastStonePosition) {
            return true;
        }
        for (int i = distance - 1; i <= distance + 1; i++) {
            if (i <= 0) continue;
            if (set.contains(position + i)) {
                return dfs(set, i, position + i, lastStonePosition);
            }
        }
        return false;
    }
}
