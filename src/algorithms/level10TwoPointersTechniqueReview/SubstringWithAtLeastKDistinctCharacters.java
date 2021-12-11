package algorithms.level10TwoPointersTechniqueReview;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithAtLeastKDistinctCharacters {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
     // 类似 1246 · Longest Repeating Character Replacement
    public long kDistinctCharacters(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long answer = 0;
        int j = 0, n = s.length();
        // using int counter[26] will be better than using hashmap (26 letters in English)
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 条件不满足，右移动 j
            while (j < n && counter.size() < k) {
                char c = s.charAt(j);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                j++;
            }
            // 当我们加入了 j - 1 位置的character后条件满足
            // j 的位置是满足条件后的第一个位置
            // 或者是走到了最后依然条件不满足
            if (j >= n && counter.size() < k) {
                break;
            }
            // "abcde", k = 3, 此时 j 的位置在 d，符合条件的substring
            // 为 "abc", "abcd", "abcde", 所以应该是cde的长度，就是
            // s.length() - 1 - (j - 1) + 1 = s.length() - j + 1
            // error before: answer +=
            answer += n - j + 1;
            // i 向右移动一位， 统计index = i的字母的总数 -1
            char c = s.charAt(i);
            counter.put(c, counter.get(c) - 1);
            // error before: without this part, counter.get(c) - 1 may less than 0
            if (counter.get(c) == 0) {
                counter.remove(c);
            }
        }
        return answer;
    }
}
