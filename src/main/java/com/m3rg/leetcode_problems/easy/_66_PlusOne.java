/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

https://leetcode.com/problems/plus-one/
 */
package com.m3rg.leetcode_problems.easy;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _66_PlusOne {
    public static void main(String[] args) {
        _66_PlusOne obj = new _66_PlusOne();
        int[] result = obj.plusOne(new int[] { 9, 9, 9 });
        ListUtils.printArray(result);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (n == 0) {
            return digits;
        }
        int[] result = new int[n];
        result[n - 1] = 1;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + result[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] newResult = new int[n + 1];
            newResult[0] = carry;
            for (int i = 1; i < n; i++) {
                newResult[i] = result[i - 1];
            }
            return newResult;
        }
        return result;
    }
}
