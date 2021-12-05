package com.company.level9DynamicProgramming;

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
        // state, 前缀型要多加 1, 前 i 个数可以凑成 j， 一共有 i + 1 个数
        int[][] dp = new int[n + 1][m + 1];
        // initialize
        for (int i = 0 ; i <= n ;i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        // function - O(n*m)
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= m; j++){
                // j >= A[i - 1]
                if (j >= A[i - 1]) {
                    // dp[i -1][j - A[i - 1]] + A[i - 1] 尽可能逼近 j, 加法运算比或运算慢， 效率低一点 (乘法，除法可以使用二进制运算)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i -1][j - A[i - 1]] + A[i - 1]);
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
