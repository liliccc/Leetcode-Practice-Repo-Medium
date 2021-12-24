package algorithms.level11BinarySearchReview;

public class TotalOccurrenceofTarget {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        if (A[A.length - 1] < target || A[0] > target) {
            return 0;
        }
        int left = 0, right = A.length - 1;
        int start = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) {
                start = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        left = 0;
        right = A.length - 1;
        int end = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                end = mid;
                // left指针向右逼近
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return end - start + 1;
    }
}
