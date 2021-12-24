package algorithms.level11BinarySearchReview;

public class SearchforaRange {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = A.length - 1;
        int leftBound = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            }
            else if (A[mid] < target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (A[left] == target) {
            leftBound = left;
        }
        else if (A[right] == target) {
            leftBound = right;
        }
        else {
            return new int[]{-1, -1};
        }
        left = 0; right = A.length - 1;
        int rightBound = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                left = mid;
            }
            else if (A[mid] < target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (A[right] == target) {
            rightBound = right;
        }
        else if (A[left] == target) {
            rightBound = left;
        }
        else {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound, rightBound};
    }
}
