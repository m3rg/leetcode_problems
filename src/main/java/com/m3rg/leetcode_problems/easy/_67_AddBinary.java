/**
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

https://leetcode.com/problems/add-binary/
 */
package com.m3rg.leetcode_problems.easy;

public class _67_AddBinary {
    public static void main(String[] args) {
        _67_AddBinary obj = new _67_AddBinary();
        String result = obj.addBinary("10111", "1111");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int sum = carry;
            if (l1 >= 0) {
                sum += a.charAt(l1) - '0';
                l1--;
            }
            if (l2 >= 0) {
                sum += b.charAt(l2) - '0';
                l2--;
            }
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
