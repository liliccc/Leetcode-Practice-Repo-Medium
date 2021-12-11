package com.company.level2TwoPointersTechnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return results;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i -1]) {
                continue;
            }
            int target = -numbers[i], end = numbers.length - 1, start = i + 1;
            findTwoSum(numbers, target, start,end, results);
        }

        return results;
    }

    private static void findTwoSum(int[] numbers, int target, int start, int end, List<List<Integer>> results) {
        while (start <= end) {
            if (numbers[start] + numbers[end] == target) {
                // reduce duplicate should be here
                while (start <= end && numbers[start] == numbers[start + 1]) {
                    start++;
                }
                while (start <= end && numbers[end] == numbers[end - 1]) {
                    end--;
                }
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(numbers[start]);
                result.add(numbers[end]);
                results.add(result);
                start++;
                end--;

            }
            else if (numbers[start] + numbers[end] < target) {
                start++;
            }
            else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,33,23,2423,33,23,1,7,6,8787,5,33,2,3,-23,-54,-67,100,400,-407,-500,-35,-8,0,0,7,6,0,1,2,-56,-89};
        System.out.println(threeSum(numbers));
    }
}
