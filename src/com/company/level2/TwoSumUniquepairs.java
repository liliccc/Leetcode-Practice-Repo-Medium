package com.company.level2;

import java.util.Arrays;

public class TwoSumUniquepairs {

    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public static int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        int front = 0;
        int end = nums.length - 1;
        while (front <= end) {
            if (nums[front] + nums[end] == target) {
                while (front <= end && nums[front] == nums[front + 1]) {
                    front++;
                }
                while (front <= end && nums[end] == nums[end - 1]) {
                    end--;
                }
                total++;
                end--;
                front++;
            }
            else if (nums[front] + nums[end] > target) {
                end--;
            }
            else {
                front++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,45,46,46};
        int target = 47;
        System.out.println(twoSum6(nums, target));
    }
}
