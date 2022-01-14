package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class FindtheMissingNumberII {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    int missing = -1;
    public int findMissing2(int n, String str) {
        dfs(n, str, new boolean[n + 1], 0);
        return missing;
    }

    private void dfs(int n, String str, boolean[] visited, int index) {
        if (str.length() == 0 && index == n -1) {
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    missing = i;
                    return;
                }
            }
        }
        // str.length() may be less than 2
        for (int i = 1; i <= 2 && i <= str.length(); i++) {
            int num = Integer.parseInt(str.substring(0, i));
            if (num > n || num == 0 || visited[num]) {
                continue;
            }
            visited[num] = true;
            dfs(n, str.substring(i, str.length()), visited, index + 1);
            visited[num] = false;
        }
    }
}
