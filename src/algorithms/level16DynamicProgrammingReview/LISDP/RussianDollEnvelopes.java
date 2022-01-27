package algorithms.level16DynamicProgrammingReview.LISDP;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    // this problem must use binary search to achieve (O(nlogn)) to pass
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                }
                return arr1[0] - arr2[0];
            }
        });
        int size = envelopes.length;
        int[] lis = new int[size + 1];
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i < size + 1; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        int longest = 0;
        for (int i = 0; i < size; i++) {
            int index = firstGTE(lis, envelopes[i][1]);
            lis[index] = envelopes[i][1];
            longest = Math.max(longest, index);
        }
        return longest;
    }

    private int firstGTE(int[] lis, int target) {
        int start = 0, end = lis.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (lis[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (lis[start] >= target) {
            return start;
        }
        return end;
    }

}
