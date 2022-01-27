package algorithms.level16DynamicProgrammingReview.PartiitionDP;

public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    // this solution need to be optimised if using dp (Quadrilateral inequality optimization)
    // better solution: binary search
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int size = pages.length;
        //state:  dp[i][j] -> i books are given to j people
        int[][] dp = new int[size + 1][k + 1];
        // initialisation
        for (int i = 1; i < size - 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        int[] prefixSum = new int[size + 1];
        for (int i = 1; i < size + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + pages[i - 1];
        }
        // function
        for (int page = 1; page < size + 1; page++) {
            for (int people = 1; people <= k; people++) {
                dp[page][people] = Integer.MAX_VALUE;
                for (int prev = 0; prev < page; prev++) {
                    int cost = prefixSum[page] - prefixSum[prev];
                    dp[page][people] = Math.min(dp[page][people], Math.max(dp[prev][people - 1], cost));
                }
            }
        }
        // answer
        return dp[size][k];
    }
}
