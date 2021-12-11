package algorithms.level6DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationII {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        List<String> permutations = new ArrayList<>();
        dfs(chars, permutations, visited, "");
        return permutations;
    }

    private void dfs(char[] chars, List<String> permutations, boolean[] visited, String permutation) {
        if (permutation.length() == chars.length) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            dfs(chars, permutations, visited, permutation + chars[i]);
            visited[i] = false;
        }
    }
}
