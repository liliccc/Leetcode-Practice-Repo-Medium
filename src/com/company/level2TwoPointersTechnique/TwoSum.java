package com.company.level2TwoPointersTechnique;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numArray = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (numArray.containsKey(diff)) {
                return new int[] {numArray.get(diff), i};
            }
            numArray.put(numbers[i], i);
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] newArray = {15,2,7,11};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(newArray, target)));
    }
}
