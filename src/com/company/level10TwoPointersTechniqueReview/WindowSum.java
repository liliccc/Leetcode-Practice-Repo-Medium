package com.company.level10TwoPointersTechniqueReview;

public class WindowSum {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
     // 求子集用双指针
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k == 0) {
            return new int[]{};
        }
        // 滑动窗口的集合区间
        int[] results = new int[nums.length - k  + 1];
        // j start from 0
        int j = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // index 从0开始，所以 j - i 不用 + 1
            while (j < nums.length && j - i < k) {
                sum += nums[j];
                j++;
            }
            if (j - i == k) {
                results[i] = sum;
            }
            sum -= nums[i];
        }
        return results;
    }
}
