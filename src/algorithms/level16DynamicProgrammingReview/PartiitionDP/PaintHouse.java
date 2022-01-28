package algorithms.level16DynamicProgrammingReview.PartiitionDP;

public class PaintHouse {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int size = costs.length;
        // state: ith house, jth color
        int[][] dp = new int[size][3];
        // initialisation
        // initialise the first house
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        // function
        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        // result
        return Math.min(dp[size - 1][0], Math.min(dp[size - 1][1], dp[size - 1][2]));
    }
}
