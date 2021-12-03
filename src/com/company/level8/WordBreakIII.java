package com.company.level8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakIII {
    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        Set<String> lowercaseDict = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();
        for (String word: dict) {
            String lowercaseWord = word.toLowerCase();
            lowercaseDict.add(lowercaseWord);
        }
        String lowercaseStr = s.toLowerCase();
        return dfs(lowercaseStr, lowercaseDict, memo);
    }
    private int dfs(String s, Set<String> dict, Map<String, Integer> memo) {
        if (s.equals("")) {
            return 1;
        }
        // 记忆化搜索
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int res = 0;
        // i starts from 1 to s.length()
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                res = res + dfs(suffix, dict, memo);
            }
        }
        memo.put(s, res);
        return res;
    }
}
