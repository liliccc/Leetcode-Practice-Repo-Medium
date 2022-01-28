package algorithms.level16DynamicProgrammingReview.CoordinateDP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        // the problem requirement
        if (!(stones[0] == 0 && stones[1] == 1)) {
            return false;
        }
        // state
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : dp.get(stone)) {
                // step - 1
                if (step > 1 && dp.containsKey(stone + step - 1)) {
                    dp.get(stone + step - 1).add(step - 1);
                }
                // step
                if (dp.containsKey(stone + step)) {
                    dp.get(stone + step).add(step);
                }
                // step + 1
                if (dp.containsKey(stone + step + 1)) {
                    dp.get(stone + step + 1).add(step + 1);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
