package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();
        dfs(s, results, new ArrayList<>(), 0);
        return results;
    }

    private void dfs(String s, List<List<String>> results, List<String> current, int index) {
        // base case(including exception)
        if (index == s.length()) {
            // must use new ArrayList<>()
            results.add(new ArrayList<>(current));
            return;
        }
        // add one character
        current.add(String.valueOf(s.charAt(index)));
        dfs(s, results, current, index + 1);
        current.remove(current.size() - 1);

        // add two character
        if (index < s.length()  -1) {
            //Backtracking
            current.add(s.substring(index, index + 2));
            dfs(s, results, current, index + 2);
            current.remove(current.size() - 1);
        }
    }
}
