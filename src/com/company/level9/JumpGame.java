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
        // state
        boolean[] dp = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = false;
        }
        // initialize
        dp[0] = true;
        // function  DP - O(n^2)
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // j可以跳得到 + 从某个j点 + j 的最大值可以跳到或者跳过i点
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                }
            }
        }
        // answer
        return dp[A.length - 1];
    }

}
