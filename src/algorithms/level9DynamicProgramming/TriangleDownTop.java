package algorithms.level9DynamicProgramming;

public class TriangleDownTop {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return - 1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        int n = triangle.length;
        int[][] dp = new int[n][n];
        // 最底层的数字
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        // 下面一层的 最小的数和上一层相加
        for (int i = n - 2; i > -1; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
