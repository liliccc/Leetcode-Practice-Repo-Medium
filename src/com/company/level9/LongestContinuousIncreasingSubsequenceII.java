package com.company.level9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestContinuousIncreasingSubsequenceII {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[] dx = {1, -1, 0 ,0};
        int[] dy = {0, 0, 1, -1};
        int n = matrix.length, m = matrix[0].length;
        List<List<Integer>> sortedPoints = new ArrayList<>();
        // 上下左右都可以走，先排序， 从小的值走起
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sortedPoints.add(Arrays.asList(i, j, matrix[i][j]));
            }
        }
        sortedPoints.sort((p1, p2) -> Integer.compare(p1.get(2), p2.get(2)));
        // state
        int[][] dp = new int[n][m];
        // string - length(), array - length, collection -size()
        for (int i = 0; i < sortedPoints.size(); i++) {
            int x = sortedPoints.get(i).get(0);
            int y = sortedPoints.get(i).get(1);
            // initialize
            dp[x][y] = 1;
            for (int j = 0; j < 4; j++) {
                int prevX = x + dx[j];
                int prevY = y + dy[j];
                if (prevX < 0 || prevX >= n || prevY < 0 || prevY >= m) {
                    continue;
                }
                if (matrix[prevX][prevY] >= matrix[x][y]) {
                    continue;
                }
                // function
                dp[x][y] = Math.max(dp[x][y], dp[prevX][prevY] + 1);
            }
        }
        // answer
        int longest = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                longest = Math.max(longest, dp[i][j]);
            }
        }
        return longest;
    }
}
