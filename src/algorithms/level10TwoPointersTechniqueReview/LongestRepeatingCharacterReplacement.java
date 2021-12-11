package algorithms.level10TwoPointersTechniqueReview;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    /**
     * @param s: a string
     * @param k: a integer
     * @return: return a integer
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> counter = new HashMap<>();
        int answer = 0, count = 0, maxFrequency = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            // <=k 才能取到最右边的数
            while (j < s.length() &&  j - i - maxFrequency <= k) {
                count = counter.getOrDefault(s.charAt(j), 0) + 1;
                counter.put(s.charAt(j), count);
                maxFrequency = Math.max(maxFrequency, count);
                j++;
            }
            // 如果替换 除出现次数最多的字母之外的其他字母 的数目>k,
            // 说明有一个不能换，答案与j-i-1进行比较；
            // 否则说明直到字符串末尾替换数目都<=k，可以全部换掉
            // 答案与子串长度j-i进行比较
            if (j - i - maxFrequency > k) {
                answer = Math.max(answer, j - i - 1);
            }
            else {
                answer = Math.max(answer, j - i);
            }
            // 起点后移一位，当前起点位置的字母个数-1
            count = counter.get(s.charAt(i)) - 1;
            counter.put(s.charAt(i), count);
        }

        return answer;
    }
}
