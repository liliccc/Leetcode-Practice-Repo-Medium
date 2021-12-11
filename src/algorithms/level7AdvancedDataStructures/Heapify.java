package algorithms.level7AdvancedDataStructures;

public class Heapify {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        for (int i = A.length / 2; i >=0 ; i--) {
            shiftDown(A, i);
        }
    }

    private void shiftDown(int[] A, int k) {
        int length = A.length;
        while (k < length) {
            int left = k * 2 + 1;
            int right = left + 1;
            int min = k;
            if (left < length && A[left] < A[min]) {
                min = left;
            }
            if (right < length && A[right] < A[min]) {
                min = right;
            }
            if (min == k) {
                break;
            }
            swap(A, min, k);
            k = min;
        }
    }
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
