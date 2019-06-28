/**
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:

Input: "42"
Output: 42

Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.

Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.

Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

------------------------
Time Complexity: O(n) n = length of string
 */
package com.m3rg.leetcode_problems.medium;

public class _8_StringToInteger {

    public static void main(String[] args) {
        String str = "  +-1 ";
        _8_StringToInteger obj = new _8_StringToInteger();
        int result = obj.myAtoi(str);
        System.out.println(result);
        int a = -2147483648;
        System.out.println(a);
    }

    public int myAtoi(String str) {
        int result = 0;
        int len = str.length();
        boolean isNegative = false;
        boolean start = false;
        for(int i = 0; i<len; i++) {
            char c = str.charAt(i);
            int digit = c - '0';
            if(c == ' ' && !start) {
                continue;
            } else if(c == '-' && !start) {
                isNegative = true;
                start = true;
            } else if(c == '+' && !start) {
                start = true;
            } else if(digit >= 0 && digit <= 9) {
                if(!isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && digit >= 7))) {
                    return Integer.MAX_VALUE;
                }
                if(isNegative && ((result * -1) < Integer.MIN_VALUE / 10 || ((result * -1) == Integer.MIN_VALUE / 10 && digit >= 8))) {
                    return Integer.MIN_VALUE;
                }
                result = (result * 10) + digit;
            } else {
                break;
            }
        }
        return result * (isNegative?-1:1);
    }

}
