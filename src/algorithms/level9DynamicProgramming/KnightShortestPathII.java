package algorithms.level9DynamicProgramming;

public class KnightShortestPathII {
    public static int[] deltaX = {1, -1, 2, -2};
    // start from negative y
    public static int[] deltaY = {-2, -2, -1, -1};
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        // state
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // initialize
        dp[0][0] = 0;
        // for loop 先j后i， 否则 x 可能比i小或者比i大, i 从小到大排序
        // function
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j]) {
                    continue;
                }
                for (int direction = 0; direction < 4; direction++) {
                    int x = i + deltaX[direction];
                    int y = j + deltaY[direction];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    // Java dp[x][y] + 1 会越界
                    if (dp[x][y] == Integer.MAX_VALUE){
                        continue;
                    }
                    // 四个点里里面的最小值
                    dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
                }
            }
        }
        // answer
        if (dp[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n - 1][m - 1];
    }
}
