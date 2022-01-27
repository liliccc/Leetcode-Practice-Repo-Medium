package algorithms.level16DynamicProgrammingReview.PartiitionDP;

import java.util.Set;

public class WordBreak {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        if (s == null) {
            return true;
        }
        int maxLength = 0;
        // reduce time complexity from O(n^2) -> O(m) + O(n)
        for (String word : wordSet) {
            maxLength = Math.max(maxLength, word.length());
        }
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int i = 1; i < size + 1; i++) {
            // [i, size - 1]
            for (int len = 1; len <= maxLength; len++) {
                if (i < len) {
                    break;
                }
                // [0, i-len], [i -len + 1, i]
                if (!dp[i - len]) {
                    continue;
                }
                String word = s.substring(i - len, i);
                if (wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }
}
