package com.company.level10TwoPointersTechniqueReview;

public class TwoSumDifferenceequalstotarget {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
     // required O(1) space complexity, 使用双指针
    public int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int n = nums.length;
        int j = 1;
        // given a sorted array, 取绝对值就可以
        target = Math.abs(target);
        for (int i = 0; i < n; i++) {
            // j 最小的值保持在i + 1， 使用判断条件if (i < j)会多循环几次
            j = Math.max(j, i + 1);
            while (j < n && nums[j] - nums[i] < target) {
                j++;
            }
            if (j >= n) {
                break;
            }
            if (nums[j] - nums[i] == target) {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{-1, -1};
    }
}
