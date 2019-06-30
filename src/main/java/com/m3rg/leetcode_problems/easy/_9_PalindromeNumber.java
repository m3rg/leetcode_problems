/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

Coud you solve it without converting the integer to a string?
 */
package com.m3rg.leetcode_problems.easy;

public class _9_PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        _9_PalindromeNumber obj = new _9_PalindromeNumber();
        boolean result = obj.isPalindrome(x);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int rev = 0;
        int y = x;
        while(y > 0) {
            int digit = y % 10;
            rev = (rev * 10) + digit;
            y /= 10;
        }
        if(rev == x) {
            return true;
        }
        return false;
    }
}