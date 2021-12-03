package com.company.level8;

public class ClimbingStairsII {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2] + step[i - 3];
        }
        return step[n];
    }
}
