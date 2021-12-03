package com.company.level9;

public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
     public int backpack(int m, int[] A) {
        if (m == 0 || A == null || A.length == 0) {
            return -1;
        }
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int v = m; v >=0; v--) {
            if (dp[n][v]) {
                return v;
            }
        }
        return -1;
     }
}
