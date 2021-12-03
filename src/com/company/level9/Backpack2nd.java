package com.company.level9;

public class Backpack2nd {
    // 这种方法比较慢
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
     public int backPack2(int m, int[] A) {
        if (m == 0 || A == null || A.length == 0) {
            return -1;
        }
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0 ; i <= n ;i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= m; j++){
                // j >= A[i - 1]
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i -1][j - A[i - 1]] + A[i - 1]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
     }
}
