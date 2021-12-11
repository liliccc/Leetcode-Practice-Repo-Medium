package algorithms.level9DynamicProgramming;

public class UniquePathsTopDown {
     // 求方案总数用 +
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        // state, 总方案数
        int[][] dp = new int[m][n];
        // initialize
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j - 1];
            }
        }
        // answer
        return dp[m - 1][n - 1];
    }
}
