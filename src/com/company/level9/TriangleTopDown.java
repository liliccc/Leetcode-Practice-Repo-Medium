package com.company.level9;

public class TriangleTopDown {
// 求最小路径用 min
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        int n = triangle.length;
        int[][] dp = new int[n][n];
        // 第一层的数字
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i ++) {
            // 最左边没有左上角，只有一条路径从下到上
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            // 最右边没有右上角，只有斜边一条路径
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                // 关键步骤
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
        // 比较最后一层哪一个数字最小
        int best = dp[n -1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, dp[n - 1][i]);
        }
        return best;
    }
}
