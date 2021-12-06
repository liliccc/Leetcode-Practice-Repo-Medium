package com.company.level3BinarySearch;

public class WoodCut {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public  static int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int maxLength = findMaxLength(L);
        int start = 0;
        while (start + 1 < maxLength) {
            int mid = start + (maxLength - start) / 2;
            if (greaterThanK(L, mid, k)) {
                start = mid;
            }
            else {
                maxLength = mid;
            }
        }
        if (greaterThanK(L, maxLength, k)) {
            return maxLength;
        }
        return start;
    }

    private static int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int num : nums) {
            maxLength = Math.max(num, maxLength);
        }
        return maxLength;
    }

    private static boolean greaterThanK (int[] nums, int lengthOfStick, int k){
        int count = 0;
        for (int num : nums) {
            count += num / lengthOfStick;
        }
        return count >= k;
    }
    public static void main(String[] args) {
        int[] nums = {232, 124, 456};
        int k = 7;
        System.out.println(woodCut(nums, k));
    }
}
