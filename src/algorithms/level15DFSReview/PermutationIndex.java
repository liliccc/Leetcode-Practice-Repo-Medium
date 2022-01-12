package algorithms.level15DFSReview;

public class PermutationIndex {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        long sum = 1;
        long factorial = 1;
        for (int i = length - 1; i >= 0; i--) {
            int smaller = 0;
            // find the number which is smaller than A[i]
            for (int j = i + 1; j < length; j++) {
                if (A[i] > A[j]) {
                    smaller++;
                }
            }
            sum += smaller * factorial;
            factorial *= (length - i);
        }
        return sum;
    }
}
