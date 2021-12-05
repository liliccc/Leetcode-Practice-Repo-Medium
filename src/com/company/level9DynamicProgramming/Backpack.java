package com.company.level9DynamicProgramming;

public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
     // dp 时间复杂度 O(n*m)
     public int backpack(int m, int[] A) {
        if (m == 0 || A == null || A.length == 0) {
            return -1;
        }
        int n = A.length;
         // state, 前缀型要多加 1, 前 i 个数可以凑成 j， 一共有 i + 1 个数
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = false;
            }
        }
        // initialize
        dp[0][0] = true;
        // function - O(n*m)
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=m; j++) {
                // A[i - 1] > j
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        // answer
        for (int v = m; v >=0; v--) {
            if (dp[n][v]) {
                return v;
            }
        }
        return -1;
     }
}
