package algorithms.level16DynamicProgrammingReview;

public class EditDistance {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int word1Len = word1.length();
        int word2Len = word2.length();
        // state
        int[][] dp = new int[word1Len + 1][word2Len + 2];
        // initialisation
        for (int i = 0; i < word1Len + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2Len + 1; i++) {
            dp[0][i] = i;
        }
        // function
        // i = 0 or j == 0 is ""(empty string)
        for (int i = 1; i < word1Len + 1; i++) {
            for (int j = 1; j < word2Len + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        // result
        return dp[word1Len][word2Len];
    }
}
