/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3

Example 2:

Input: dividend = 7, divisor = -3
Output: -2

Note:

    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

Explanation: https://www.youtube.com/watch?v=htX69j1jf5U

Time Complexity: O(logN^2)

https://leetcode.com/problems/divide-two-integers/
 */
package com.m3rg.leetcode_problems.medium;

public class _29_DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = 12;
        int divisor = 4;
        _29_DivideTwoIntegers obj = new _29_DivideTwoIntegers();
        int result = obj.divide(dividend, divisor);
        System.out.println(result);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        return isNegative ? -res : res;
    }

    // Solution 2 - Recursive
    public int recursive(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;

        return isNeg ? -div(dividend, divisor) : div(dividend, divisor);
    }

    public int div(int divid, int divis) {
        if (divid > divis)
            return 0;
        int curSum = divis << 1, prevSum = divis, q = 1;

        while (divid <= curSum && curSum < prevSum) {
            prevSum = curSum;
            curSum <<= 1;
            q <<= 1;
        }
        return q + div(divid - prevSum, divis);
    }
}
