package com.company.level3BinarySearch;

public class FindMinimuminRotatedSortedArray {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end -start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        // wrong here
        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }
}
