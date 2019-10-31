/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000

Example 2:

Input: 2.10000, 3
Output: 9.26100

Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:

    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]

https://leetcode.com/problems/powx-n/
 */
package com.m3rg.leetcode_problems.medium;

public class _50_PowXn {
    public static void main(String[] args) {
        _50_PowXn obj = new _50_PowXn();
        // double result = obj.myPow(0.00001, 2147483647);
        // double result = obj.myPow(2, 2147483647);
        double result = obj.myPow(2, 2147483647);
        System.out.println(result);

    }

    // Solution 1: Iterative
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long) n;
        double ans = 1.0;
        while (m != 0) {
            // if ((m & 1) == 1) {
            if (m % 2 == 1) {
                ans *= x;
            }
            x *= x;
            // m >>= 1;
            m /= 2;
        }
        return n >= 0 ? ans : 1 / ans;
    }

    // Solution 2: Recursive
    public double recursive(double x, int n) {
        if (n == 0) {
            return (double) 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x = 1 / x * 1 / x;
            }
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? recursive(x * x, n / 2) : x * recursive(x * x, n / 2);
    }
}
