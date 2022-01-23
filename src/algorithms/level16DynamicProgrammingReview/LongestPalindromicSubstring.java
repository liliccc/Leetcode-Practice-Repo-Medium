package algorithms.level16DynamicProgrammingReview;

public class LongestPalindromicSubstring {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        // state
        boolean[][] isPalindrome = new boolean[n][n];
        int longest = 1, start = 0;
        // initialisation
        // find the longest is 1
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        // find the longest is 2
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                longest = 2;
                start = i;
            }
        }
        // function ( find the longest in [i, j])
        // find the longest is more than 2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    // i start from 0, longest should be j - i + 1
                    // error before: longest = Math.max(longest, j - i + 1); => start is always changing
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
