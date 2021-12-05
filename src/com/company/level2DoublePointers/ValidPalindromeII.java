package com.company.level2DoublePointers;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String input = "ab";
        System.out.println(validPalindrome(input));
    }

    public static boolean validPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        int front = 0;
        int end = input.length() - 1;
        Pair firstPair = findDifference(input, front, end);
        if (firstPair.front >= firstPair.end) {
            return true;
        }
        return isPalindrome(input, firstPair.front + 1, firstPair.end)
        || isPalindrome(input, firstPair.front, firstPair.end  - 1);
    }

    private static Pair findDifference(String input, int front, int end) {
        while (front < end) {
            if (input.charAt(front) == input.charAt(end)) {
                front++;
                end--;
            }
            else {
                break;
            }
        }
        return new Pair(front, end);
    }
    private static boolean isPalindrome(String input, int front, int end) {
        Pair newPair = findDifference(input, front, end);
        return newPair.front >= newPair.end;
    }
}

class Pair  {
    public int front;
    public int end;

    public Pair(int front, int end) {
        this.front = front;
        this.end = end;
    }
}
