package algorithms.level16DynamicProgrammingReview.IntervalDP;

public class StoneGame {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // state
        int size = A.length;
        int[][] dp = new int[size][size];
        int[] prefixSum = new int[size + 1];
        // initialise
        for (int i = 0; i < size; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        // function
        // when len == 1, dp == 0
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i + len - 1 < size; i++) {
                int left = i, right = i + len -1;
                dp[left][right] = Integer.MAX_VALUE;
                int cost = prefixSum[right + 1] - prefixSum[left];
                for (int mid = left; mid < right; mid++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][mid] + dp[mid + 1][right] + cost);
                }
            }
        }
        // result
        return dp[0][size - 1];
    }
}
