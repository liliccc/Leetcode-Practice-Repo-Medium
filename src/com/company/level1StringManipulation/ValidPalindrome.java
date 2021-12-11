package com.company.level1StringManipulation;

public class ValidPalindrome {

    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String newString = convertToNewString(s);
        int front = 0;
        int end = newString.length() - 1;
        while (front < end ) {
            if (newString.charAt(front) == newString.charAt(end)) {
                front++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private static String convertToNewString (String input) {
        char[] oldString = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : oldString) {
//            if (Character.isAlphabetic(c)) {
//                builder.append(c);
//            }
            if ((c >= 'a' && c <= 'z') || Character.isDigit(c)) {
                builder.append(c);
            }
            else if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
                builder.append(c);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String input = "1a2";
        System.out.println(convertToNewString(input));
        System.out.println(isPalindrome(input));

    }


}
