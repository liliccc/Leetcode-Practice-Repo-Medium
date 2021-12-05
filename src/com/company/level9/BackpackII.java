package com.company.level9;

public class BackpackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        if (m <= 0 || A == null || V == null) {
            return 0;
        }
        int n = A.length;
        // state
        int[][] dp = new int[n + 1][m + 1];
        // initialize
        for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j ++) {
            dp[i][j] = 0;
         }
        }
        // function
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <=m ; j++) {
                if (j >= A[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
