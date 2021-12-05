package com.company.level9DynamicProgramming;

public class UniquePathsDownTop {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        // state
        int[][] dp = new int[m][n];
        // initialize
        for (int i = 0; i < m; i++) {
            // initialization start from n - 1 and m - 1
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }
        // function
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        // answer
        return dp[0][0];
    }
}
