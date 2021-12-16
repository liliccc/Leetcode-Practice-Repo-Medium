package algorithms.level11BinarySearchReview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
     // 有三种解决方法，以下使用二分法解决
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        // error before: must sort nums1
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int number : nums2) {
            if (set.contains(number)) {
                continue;
            }
            if (binarySearch(nums1, number)) {
                set.add(number);
            }
        }
        int[] results = new int[set.size()];
        int index = 0;
        for (int number: set) {
            results[index++] = number;
        }
        return results;
    }

    private boolean binarySearch(int[] nums1, int target) {
        if (nums1 == null || nums1.length == 0) {
            return false;
        }
        int start = 0, end = nums1.length - 1;
        while (start + 1 < end) {
            int mid = start + (end -start) / 2;
            if (nums1[mid] == target) {
                return true;
            }
            if (nums1[mid] <target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums1[start] == target) {
            return true;
        }
        if (nums1[end] == target) {
            return true;
        }
        return false;
    }
}
