package com.company.level6DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumII {
    /**
     * @param A: an integer array
     * @param k: a positive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (A == null || A.length == 0) {
            return results;
        }
        Arrays.sort(A);
        dfs(A, k , target, results, new ArrayList<>(), 0);
        return results;
    }

    private void dfs(int[] A, int k, int target, List<List<Integer>> results, List<Integer> combination, int start) {
        if (k == 0 && target == 0 ) {
            // deep copy is important, otherwise it is []
            results.add(new ArrayList<>(combination));
            return;
        }
        if (k == 0 || target < 0) {
            return;
        }
        for (int i = start; i < A.length; i++) {
            combination.add(A[i]);
            dfs(A, k - 1, target - A[i], results, combination, i  + 1);
            combination.remove(combination.size() - 1);
        }
    }


}
