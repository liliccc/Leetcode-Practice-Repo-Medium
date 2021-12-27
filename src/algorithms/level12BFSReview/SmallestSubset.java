package algorithms.level12BFSReview;

import java.util.Arrays;

public class SmallestSubset {
    /**
     * @param arr:  an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int halfSum = 0;
        for (int num: arr) {
            halfSum += num;
        }
        halfSum = halfSum / 2;
        int minimumNum = 0, minimumSum = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >0 ; i--) {
            minimumSum += arr[i];
            minimumNum++;
            if (minimumSum > halfSum) {
                break;
            }
        }
        return minimumNum;
    }
}
