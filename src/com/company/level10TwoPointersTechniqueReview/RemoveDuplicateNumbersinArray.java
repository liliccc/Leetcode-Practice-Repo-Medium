package com.company.level10TwoPointersTechniqueReview;

import java.util.Arrays;

public class RemoveDuplicateNumbersinArray {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
     // Do it in place 不能有额外空间，找到子集，使用双指针
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 未排列， 需要排列
        Arrays.sort(nums);
        int j = 1, i;
        for (i = 0; i < nums.length; i++) {
            j = Math.max(j, i + 1);
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            nums[i + 1] = nums[j];
        }
        return i + 1;
    }
}
