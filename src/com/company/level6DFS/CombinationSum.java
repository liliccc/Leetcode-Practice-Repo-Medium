package com.company.level6DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        int[] nums = removeDuplicates(candidates);
        dfs(nums, results, target, new ArrayList<>(), 0);
        return results;
    }

    private void dfs(int[] candidates, List<List<Integer>> results, int target, List<Integer> combination, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates, results, target - candidates[i], combination, i);
            combination.remove(combination.size() - 1);
        }
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] newCandidate = new int[index + 1];
        // length = index + 1
        for (int i = 0; i < index + 1; i++) {
            newCandidate[i] = candidates[i];
        }
        return newCandidate;
    }
}
