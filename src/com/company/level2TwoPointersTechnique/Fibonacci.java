package com.company.level2TwoPointersTechnique;

public class Fibonacci {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 0;
        if (n < 2)  {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }

}
