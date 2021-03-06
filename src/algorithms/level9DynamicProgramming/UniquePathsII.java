package algorithms.level9DynamicProgramming;

public class UniquePathsII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 1;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // state
        int[][] dp = new int[m][n];
        // initialize
        for (int i = 0; i < m; i++) {
            // 有障碍
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            // 有障碍
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        // function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 有障碍
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                // TOP DOWN
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // answer, 总路径数
        return dp[m - 1][n - 1];
    }
}
