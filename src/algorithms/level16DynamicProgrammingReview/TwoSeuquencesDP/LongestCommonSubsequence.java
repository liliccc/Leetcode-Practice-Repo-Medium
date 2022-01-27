package algorithms.level16DynamicProgrammingReview.TwoSeuquencesDP;

public class LongestCommonSubsequence {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int Alen = A.length(), Blen = A.length();
        // state + initialization
        int[][] dp = new int[Alen + 1][Blen + 1];
        // function
        for (int i = 1; i < Alen + 1; i ++) {
            for (int j = 1; j < Blen + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i -1) == B.charAt(j -1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[Alen][Blen];
    }
}
