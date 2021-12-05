package com.company.level9DynamicProgramming;

public class LongestIncreasingSubsequence {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        // state
        int[] dp = new int[n];
        // initialize
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // function
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // dp[j] + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // answer
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
