package algorithms.level10TwoPointersTechniqueReview;

public class MergeSortedArrayeasyversion {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // 合并数组或者字串，从后向前处理
        int index = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (B[indexB] > A[indexA]) {
                A[index--] = B[indexB--];
//                A[index] = B[indexB];
//                index--;
//                indexB--;
            }
            else {
                A[index--] = A[indexA--];
//                A[index] = A[indexA];
//                index--;
//                indexA--;
            }
        }
        while (indexB >= 0) {
            A[index--] = B[indexB--];
//            A[index] = B[indexB];
//            index--;
//            indexB--;
        }
    }
}
