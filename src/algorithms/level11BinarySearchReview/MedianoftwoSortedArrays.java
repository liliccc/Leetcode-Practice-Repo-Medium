package algorithms.level11BinarySearchReview;

public class MedianoftwoSortedArrays {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            return -1;
        }
        int n = A.length + B.length;
        if (n % 2 == 0) {
            return (findKthNumber(A, B, n / 2) + findKthNumber(A, B, n / 2 + 1)) / 2.0;
        }
        return findKthNumber(A, B, n / 2 + 1);
    }

    // get the middle value of 2 arrays
    private int findKthNumber(int[] A, int[] B, int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }
        int min = Math.min(A[0], B[0]);
        int max = Math.max(A[A.length - 1], B[B.length - 1]);
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            if (findIndexEqualOrSmallerThanMid(A, mid) + findIndexEqualOrSmallerThanMid(B, mid) < k) {
                min = mid;
            }
            // find the leftmost index
            else {
                max = mid;
            }
        }
        if (findIndexEqualOrSmallerThanMid(A, min) + findIndexEqualOrSmallerThanMid(B, min) >= k) {
            return min;
        }
        return max;
    }

    // find the index of an array which is the closest to the given number
    private int findIndexEqualOrSmallerThanMid(int[] array, int number) {
        int start = 0, end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= number) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        // array[start] or array[end] may be duplicated, so must be > number to find the rightmost index
        if (array[start] > number) {
            return start;
        }
        if (array[end] > number) {
            return end;
        }
        return array.length;
    }
}
