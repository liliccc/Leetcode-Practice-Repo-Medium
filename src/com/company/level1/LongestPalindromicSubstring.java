package com.company.level1;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "abb";
        System.out.println(longestPalindrome(input));
    }

    /**
     * @param inputString: input string
     * @return: a string as the longest palindromic substring
     */
    public static String longestPalindrome(String inputString) {
        if (inputString == null || (inputString.length() == 0)) {
            return "";
        }

        int start = 0, len = 0, longest = 0, oddOrEven = inputString.length() % 2;
        for (int i = 0; i < inputString.length(); i++) {
        // when i reaches the center of palindromic substring, it can calculate the len
//        if (oddOrEven != 0) {
            // odd substring number
            len = findLongestPalindromeFrom(inputString, i, i);
            if (len > longest) {
                longest = len;
                start = i - longest / 2;
            }
//        }
//        if (oddOrEven == 0) {
            // even substring number (i  + 1)
            len = findLongestPalindromeFrom(inputString, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - longest / 2 + 1;
            }
//        }
        }

        return inputString.substring(start, start + longest);
    }

    private static int findLongestPalindromeFrom(String inputString, int left, int right) {
        int len = 0;
        while (left >= 0 && right < inputString.length()) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }
        return len;
    }
}
