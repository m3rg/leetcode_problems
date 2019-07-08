/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.

https://leetcode.com/problems/longest-common-prefix/
 */
package com.m3rg.leetcode_problems.easy;

import java.util.Arrays;

public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flower"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        String result = obj.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int len = strs.length;
        if(strs == null || len == 0) {
            return "";
        }
        Arrays.sort(strs);
        char[] c1 = strs[0].toCharArray();
        char[] c2 = strs[len-1].toCharArray();
        int c2Len = c2.length;
        for(int i = 0; i<c1.length; i++) {
            if(c2Len > i && c1[i] == c2[i]) {
                sb.append(c1[i]);
            }else {
                break;
            }
        }
        return sb.toString();
    }
}