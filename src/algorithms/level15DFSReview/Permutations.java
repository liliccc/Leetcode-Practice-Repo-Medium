package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        // including nums.length == 0
        dfs(nums, new ArrayList<>(), results, new boolean[nums.length]);
        return results;
    }

    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> results, boolean[] visited) {
        // 1. base case
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //Backtracking
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, permutation, results, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
