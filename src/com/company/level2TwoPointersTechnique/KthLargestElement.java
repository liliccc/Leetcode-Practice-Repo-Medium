package com.company.level2TwoPointersTechnique;

public class KthLargestElement {
    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int k, int[] nums) {
        if (nums == null || k < 1 || nums.length < k) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            // big to small ---> >
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        int k = 1;
        System.out.println(kthLargestElement(k, nums));
    }
}
