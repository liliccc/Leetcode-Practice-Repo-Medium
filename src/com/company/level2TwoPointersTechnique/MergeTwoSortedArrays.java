package com.company.level2TwoPointersTechnique;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        int[] mergeArray = new int[A.length + B.length];
        int aStart = 0, bStart = 0, index = 0;
        while (aStart < A.length && bStart < B.length) {
            if (A[aStart] < B[bStart]) {
                mergeArray[index++] = A[aStart++];
            }
            else {
                mergeArray[index++] = B[bStart++];
            }
        }
        while (aStart < A.length) {
            mergeArray[index++] = A[aStart++];
        }
        while (bStart < B.length) {
            mergeArray[index++] = B[bStart++];
        }
        return mergeArray;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {2,4,5,6};
        System.out.println(Arrays.toString(mergeSortedArray(nums1, nums2)));

    }
}
