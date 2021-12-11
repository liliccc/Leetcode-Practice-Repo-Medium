package algorithms.level9DynamicProgramming;

public class MinimumPartition {
    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums
     */
     public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int n = nums.length;
         for (int num : nums) {
             sum += num;
         }
         int m = sum / 2;
         boolean[][] dp = new boolean[n + 1][m + 1];
         for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = false;
            }
         }
         dp[0][0] = true;
         for (int i = 1; i <=n ; i++) {
             for (int j = 0; j <=m; j++) {
                 dp[i][j] = dp[i - 1][j];
                 if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]) {
                     dp[i][j] = true;
                 }
             }
         }
         for (int v = m; v >=0; v--) {
             if (dp[n][v]) {
                 return Math.abs(sum - 2 * v);
             }
         }
         return -1;
     }

    public static void main(String[] args) {
        int[] nums = {1,5,6,11,21};
        System.out.println(findMin(nums));
    }
}
