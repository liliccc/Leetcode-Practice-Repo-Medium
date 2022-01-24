package algorithms.level16DynamicProgrammingReview;

public class BurstBalloons {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int newSize = size + 2;
        // [1, ..., 1]
        int[] newNums = new int[newSize];
        newNums[0] = newNums[newSize - 1] = 1;
        for (int i = 1; i <= size; i++) {
            newNums[i] = nums[i - 1];
        }
        // state
        int[][] dp = new int[newSize][newSize];
        // initialisation, the length between 2 balloons is at least 3
        for (int i = 0; i < newSize - 1; i++) {
            dp[i][i + 1] = 0;
        }
        // function
        for (int len = 3; len <= newSize; len++) {
            for (int left = 0; left + len - 1 < newSize; left++) {
                int right = left + len - 1;
                dp[left][right] = 0;
                for (int mid = left + 1; mid < right; mid++) {
                    // error before:  dp[left][mid] + dp[mid + 1][right]
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid] + dp[mid][right] + newNums[left] * newNums[mid] * newNums[right]);
                }
            }
        }
        return dp[0][newSize - 1];
    }
}
