package com.company.level2TwoPointersTechnique;

public class PartitionArray {

    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        // <= ? <
        while (start <= end) {
            while (start <= end && nums[start] < k) {
                start++;
            }
            while (start <= end && nums[end] >= k) {
                end--;
            }
            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,1};
        int k = 2;
        System.out.println(partitionArray(nums, k));
    }

}
