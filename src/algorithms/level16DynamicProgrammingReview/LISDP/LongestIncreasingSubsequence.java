package algorithms.level16DynamicProgrammingReview.LISDP;

public class LongestIncreasingSubsequence {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    // optimise time complexity with greedy algorithm and binary search (from O(n^2) to O(nlogn))
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int[] lis = new int[size + 1];
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i < size; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        int longest = 0;
        for (int num : nums) {
            int index = firstGTE(lis, num);
            lis[index] = num;
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
