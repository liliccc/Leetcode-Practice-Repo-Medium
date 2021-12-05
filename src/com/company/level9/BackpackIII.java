package com.company.level9;

public class BackpackIII {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        if (m == 0 || A ==  null || V == null) {
            return 0;
        }
        int n = A.length;
        // state (n + 1)(m + 1)
        int[][] dp = new int[n + 1][m + 1];
        // initialize
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = 0;
            }
        }
        // function
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <=m ; j++) {
                if (j >= A[i - 1]) {
                    // 多重背包状态转移方程 - dp[i][j - A[i - 1]] + V[i -1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - A[i - 1]] + V[i -1]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // answer
        return dp[n][m];
    }
}
