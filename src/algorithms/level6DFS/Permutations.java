package algorithms.level6DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> subset, List<List<Integer>> results) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            subset.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, subset, results);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }
}
