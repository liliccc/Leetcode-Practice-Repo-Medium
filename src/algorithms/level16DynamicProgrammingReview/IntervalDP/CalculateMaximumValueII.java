package algorithms.level16DynamicProgrammingReview.IntervalDP;

public class CalculateMaximumValueII {
    /**
     * @param str: a string of numbers
     * @return: the maximum value
     */
    public int maxValue(String str) {
        if (str == null) {
            return 0;
        }
        int size = str.length();
        // state
        int[][] dp = new int[size][size];
        // initialisation
        for (int i = 0; i < size; i++) {
            dp[i][i] = (int) str.charAt(i) - (int) '0';
        }
        // function
        // error before: len = 1
        for (int len = 2; len <= size; len++) {
            for (int left = 0; left + len - 1 < size; left++) {
                int right = left + len - 1;
                // error before mid = left + 1
                for (int mid = left; mid < right; mid++) {
                    // partition is "+" or "*"
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid] + dp[mid + 1][right]);
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid] * dp[mid + 1][right]);

                }
            }
        }
        return dp[0][size - 1];
    }
}
