package algorithms.level16DynamicProgrammingReview.TwoSeuquencesDP;

public class WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sLen = s.length(), pLen = p.length();
        // state
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // initialisation ("" <-> "")
        dp[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        // function
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }

        return dp[sLen][pLen];
    }
}
