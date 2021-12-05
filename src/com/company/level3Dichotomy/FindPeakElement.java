package com.company.level3Dichotomy;

public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }
        // the last number must be smaller than previous number
        int start = 1, end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if (A[mid + 1] > A[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (A[start] > A[end]) {
            return start;
        }
        else {
            return end;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7,8,6};
        System.out.println(findPeak(nums));
    }
}
