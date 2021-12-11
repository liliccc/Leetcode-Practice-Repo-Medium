package algorithms.level9DynamicProgramming;

import java.util.*;

public class LargestDivisibleSubset {
    /**
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 可以从任意一个数值开始，需要sort从最小值开始接龙
        Arrays.sort(nums);
        int n = nums.length;
        // state
        Map<Integer, Integer> dp = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        // initialize
        for (int i = 0; i < n; i++) {
            dp.put(nums[i], 1);
            prev.put(nums[i], -1);
        }
        // function
        int lastNum = nums[0];
        for (int i = 0; i < n ; i++) {
            int num = nums[i];
            for (int factor : getFactors(num)) {
                if (!dp.containsKey(factor)) {
                    continue;
                }
                if (dp.get(num) < dp.get(factor) + 1) {
                    dp.put(num, dp.get(factor) + 1);
                    prev.put(num, factor);
                }
            }
            // error before
            if (dp.get(num) > dp.get(lastNum)) {
                lastNum = num;
            }
        }
        return getPath(prev, lastNum);
    }
    // Time Complexity: O(n^(1/2))
    private List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        if (num == 1) {
            return factors;
        }
        int factor = 1;
        while (factor * factor <= num) {
            // num = 15
            if (num % factor == 0) {
                // factor 1 = 3
                factors.add(factor);
                // factor 2 = 5
                if (factor != 1 && num / factor != factor) {
                    factors.add(num / factor);
                }
            }
            // factor 1 ++
            factor++;
        }
        return factors;
    }

    private List<Integer> getPath(Map<Integer, Integer> prev, int lastNum) {
        List<Integer> path = new ArrayList<>();
        // 从后往前添加到path里
        while (lastNum != -1) {
            path.add(lastNum);
            lastNum = prev.get(lastNum);
        }
        Collections.reverse(path);
        return path;
    }
}
