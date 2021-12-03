package com.company.level9;

public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[A.length - 1];
    }

}
