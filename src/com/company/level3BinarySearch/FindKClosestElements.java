package com.company.level3BinarySearch;

import java.util.Arrays;

public class FindKClosestElements {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public static int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k < 0) {
            return null;
        }
        int[] results = new int[k];
        int start = findLeftNearestIndex(A, target);
        int end = start + 1;
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, start, end, target)) {
                results[i] = A[start];
                start--;
            }
            else {
                results[i] = A[end];
                end++;
            }
        }
        return results;
    }

    private static boolean isLeftCloser(int[] nums, int start, int end, int target) {
        if (start < 0) {
            return false;
        }
        if (end >= nums.length) {
            return true;
        }
        if (target - nums[start] != nums[end] - target) {
            return target - nums[start] < nums[end] - target;
        }
        return true;
    }

    private static int findLeftNearestIndex(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[end] < target) {
            return end;
        }
        if (nums[start] < target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,8,12,16,28,38};
        int target = 38;
        int k = 4;
        System.out.println(Arrays.toString(kClosestNumbers(nums, target, k)));
    }
}
