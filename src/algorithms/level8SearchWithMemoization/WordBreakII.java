package algorithms.level8SearchWithMemoization;

import java.util.*;

public class WordBreakII {
    // 求具体方案总数用dp + 记忆化搜索(DFS 也可以但是可能会栈溢出), 求所有具体方案用 DFS + 记忆化搜索
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordDict, memo);
    }
    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        if (wordDict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i <= s.length() ; i++) {
            String prefix = s.substring(0, i);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            String suffix = s.substring(i);
            for (String sub : dfs(suffix, wordDict, memo)) {
                res.add(prefix + " " + sub);
            }
        }
        memo.put(s, res);
        return res;
    }
}
