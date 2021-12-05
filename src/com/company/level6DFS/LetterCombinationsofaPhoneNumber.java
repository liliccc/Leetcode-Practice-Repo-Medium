package com.company.level6DFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all possible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        dfs(digits, results, "", 0);
        return results;
    }

    private void dfs(String digits, List<String> results, String combination, int start) {
        if (start == digits.length()) {
            results.add(combination);
            return;
        }
        int index = digits.charAt(start) - '0';
        for (int i = 0; i < KEYBOARD[index].length(); i++) {
            // start + 1 not index + 1
            dfs(digits, results, combination + KEYBOARD[index].charAt(i), start + 1);
        }
    }

    public static String[] KEYBOARD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
}
