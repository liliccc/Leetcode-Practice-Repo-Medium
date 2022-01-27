package algorithms.level16DynamicProgrammingReview.PartiitionDP;

public class DecodeWays {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        // state dp[i % 3]
        int[] dp = new int[3];
        // initialisation
        dp[0] = 1;
        dp[1] = decodeCanBeDone(s.substring(0, 1));

        for (int i = 2; i <= size; i++) {
            // i % 3 rolling array algorithm optimisation
            dp[i % 3] = dp[(i - 1) % 3] * decodeCanBeDone(s.substring(i - 1, i)) + dp[(i - 2) % 3] * decodeCanBeDone(s.substring(i - 2, i));
        }
        return dp[size % 3];
    }

    private int decodeCanBeDone(String substring) {
        int num = Integer.parseInt(substring);
        int len = substring.length();
        // "0" & "01" are not allowed to be decoded
        if (len == 1 && (num >= 1 && num <= 9)) {
            return 1;
        }
        if (len == 2 && (num >= 10 && num <= 26)) {
            return 1;
        }
        return 0;
    }
}
