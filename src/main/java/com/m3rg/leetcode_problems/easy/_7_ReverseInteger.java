package com.m3rg.leetcode_problems.easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class _7_ReverseInteger {

    public static void main(String[] args) {
        int x = 299999999;
        _7_ReverseInteger obj = new _7_ReverseInteger();
        int result = obj.reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            int digit = x % 10;
            x /= 10;
            if(reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if(reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reverse = 10 * reverse + digit;
        }
        return reverse;
    }
}
