package algorithms.level16DynamicProgrammingReview.TwoSeuquencesDP;

public class MinimumASCIIDeleteSumforTwoStrings {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: the lowest ASCII sum of deleted characters to make two strings equal
     */
    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int s1Len = s1.length(), s2Len = s2.length();
        int sum = 0;
        for (int i = 0; i < s1Len; i++) {
            sum += (int) s1.charAt(i);
        }
        for (int i = 0; i < s2Len; i++) {
            sum += (int) s2.charAt(i);
        }
        // state + initialisation
        int[][] dp = new int[s1Len + 1][s2Len + 1];
        // function
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j- 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (int) s1.charAt(i - 1));
                }
            }
        }
        return sum - 2 * dp[s1Len][s2Len];
    }
}
