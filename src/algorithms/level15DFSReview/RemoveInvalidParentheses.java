package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        int[] leftRightCount = getLeftRightCount(s);
        dfs(s, 0, leftRightCount[0], leftRightCount[1], results);
        return results;
    }

    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
        if (leftCount == 0 && rightCount == 0 && isStingEnd(s)) {
            results.add(s);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (i > startIndex && s.charAt(i) == s.charAt(i- 1)) {
                continue;
            }
            if (leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
            }
            if (rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
            }
        }
    }

    private boolean isStingEnd(String s) {
        int[] leftRightCount = getLeftRightCount(s);
        return leftRightCount[0] == 0 && leftRightCount[1] == 0;
    }

    private int[] getLeftRightCount(String str) {
        int[] count = new int[]{0, 0};
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count[0]++;
            }
            else if (c == ')') {
                if (count[0] > 0) {
                    count[0]--;
                }
                else {
                    count[1]++;
                }
            }
        }
        return count;
    }
}
