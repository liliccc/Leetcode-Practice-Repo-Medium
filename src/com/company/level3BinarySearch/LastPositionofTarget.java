package com.company.level3BinarySearch;

public class LastPositionofTarget {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public static int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            // to the left
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // search the right side
                start = mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {

    }


}
