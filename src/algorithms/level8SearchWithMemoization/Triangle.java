package algorithms.level8SearchWithMemoization;

import java.util.HashMap;
import java.util.Map;

public class Triangle {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        return divideConquer(triangle, 0 , 0, new HashMap<>());
    }

    private int divideConquer(int[][] triangle, int x, int y, Map<Integer, Integer> memo) {
        if (x == triangle.length) {
            return 0;
        }
        int hashCode = x * triangle.length + y;
        if (memo.containsKey(hashCode)) {
            return memo.get(hashCode);
        }
        int left = divideConquer(triangle, x + 1, y, memo);
        int right = divideConquer(triangle, x+ 1, y + 1, memo);
        // add triangle[x][y]
        memo.put(hashCode, Math.min(left, right) + triangle[x][y]);
        return memo.get(hashCode);
    }
}
