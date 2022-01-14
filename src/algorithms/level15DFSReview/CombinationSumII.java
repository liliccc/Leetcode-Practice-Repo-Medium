package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        Arrays.sort(num);
        dfs(num, target, 0, results, new ArrayList<>());
        return results;
    }

    private void dfs(int[] num, int target, int index, List<List<Integer>> results, List<Integer> combination) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < num.length; i++) {
            // the solution must not contain duplicate combinations
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            if (target < num[i]) {
                break;
            }
            combination.add(num[i]);
            // error before: index + 1, get all the combinations including the same numbers in different orders
            dfs(num, target - num[i], i + 1, results, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
