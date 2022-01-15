package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        dfs(n, k, 1, combinations, new ArrayList<>());
        return combinations;
    }

    private void dfs(int n, int k, int pos, List<List<Integer>> combinations, List<Integer> combination) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (pos == n + 1) {
            return;
        }
        // the total number of the last nums can not fill the k spaces (pruning可行性剪枝)
        if (combination.size() + (n - pos + 1) < k) {
            return;
        }
        // add pos in subset, backtracking
        combination.add(pos);
        dfs(n, k, pos + 1, combinations, combination);
        combination.remove(combination.size() - 1);

        // not add pos in subsut
        dfs(n, k, pos + 1, combinations, combination);
    }
}
