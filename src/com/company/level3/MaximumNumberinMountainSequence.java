package com.company.level3;

public class MaximumNumberinMountainSequence {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public static int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // compare to mid + 1 to prevent out of boundary
            if (nums[mid] >= nums[mid + 1]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 6, 3};
        System.out.println(mountainSequence(nums));
    }


}
