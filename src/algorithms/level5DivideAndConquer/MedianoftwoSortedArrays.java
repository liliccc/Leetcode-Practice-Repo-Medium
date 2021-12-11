package algorithms.level5DivideAndConquer;

public class MedianoftwoSortedArrays {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int aLength = A.length, bLength = B.length;
        int p1 = 0, p2 = 0;
        int right = 0, left = 0;
        for (int i = 0; i < (aLength + bLength) / 2 + 1; i++) {
            left = right;
            if (p1 >= aLength || p2 < bLength && A[p1] > B[p2]) {
                right = B[p2++];
            }
            else {
                right = A[p1++];
            }
        }
        return (aLength + bLength) % 2 == 1 ? right : (left + right) / 2.0;
    }
}
