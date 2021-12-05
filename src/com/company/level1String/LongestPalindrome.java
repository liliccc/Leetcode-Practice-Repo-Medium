package com.company.level1String;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> nonDuplex = new HashSet<>();
        for (char character : s.toCharArray()) {
            if (nonDuplex.contains(character)) {
                nonDuplex.remove(character);
            }
            else {
                nonDuplex.add(character);
            }
        }
        int nonDuplexLen = nonDuplex.size();
        int stringLen = s.length();
        if (nonDuplexLen > 0) {
            nonDuplexLen -= 1;
        }
        return stringLen - nonDuplexLen;
    }

    public static void main(String[] args) {
        String input = "aaaa";
        System.out.println(longestPalindrome(input));

    }
}
