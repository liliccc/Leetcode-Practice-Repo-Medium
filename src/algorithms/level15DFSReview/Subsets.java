package algorithms.level15DFSReview;

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
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, results);
        return results;
    }
    // 1. the definition of recursion
    private void dfs(int[] nums, List<Integer> subset, int index, List<List<Integer>> results) {
        // 2. the exit of dfs
        // including nums == null || nums.length == 0
        if (index == nums.length) {
            results.add(new ArrayList<>(subset));
            // error before: forget to end the recursion
            return;
        }
        // 3. different steps of dfs
        // choose nums[index]
        subset.add(nums[index]);
        dfs(nums, subset, index + 1, results);
        // not choose nums[index]
        // error before: remove(num)
        subset.remove(subset.size() - 1);
        dfs(nums, subset, index + 1, results);
    }
}
