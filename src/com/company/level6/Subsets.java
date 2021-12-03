package com.company.level6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subset,List<List<Integer>> results) {
        if (startIndex == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }
        // add nums[i]
        subset.add(nums[startIndex]);
        dfs(nums, startIndex + 1, subset, results);
        // not add nums[i]
        subset.remove(subset.size() - 1);
        dfs(nums, startIndex + 1, subset, results);

    }
}
