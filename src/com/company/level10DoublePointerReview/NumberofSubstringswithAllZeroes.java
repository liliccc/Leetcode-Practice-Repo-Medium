package com.company.level10DoublePointerReview;

public class NumberofSubstringswithAllZeroes {
    /**
     * @param str: the string
     * @return: the number of substrings
     */
     // 看见substring（字串）使用双指针
    public int stringCount(String str) {
        if (str == null) {
            return 0;
        }
        int j = 1, answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                continue;
            }
            // 保证 j 在 i 的右边
            j = Math.max(j, i + 1);
            while (j < str.length() && str.charAt(j) == '0') {
                j++;
            }
            answer += j - i;
        }
        return answer;
    }
}
