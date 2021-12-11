package algorithms.level10TwoPointersTechniqueReview;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
     // O(1) extra space - double pointers - opposite directions
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        Arrays.sort(numbers);
        int bestAnswer = numbers[0] + numbers[1] + numbers[2];
        int n = numbers.length;
        for (int left = 0 ; left < n; left ++) {
            int mid = left + 1, right = n - 1;
            while (mid < right) {
                int sum = numbers[left] + numbers[mid] + numbers[right];
                if (Math.abs(target - sum) < Math.abs(target - bestAnswer)) {
                    bestAnswer = sum;
                }
                if (sum < target) {
                    mid++;
                }
                else {
                    right--;
                }
            }
        }
        return bestAnswer;
    }
}
