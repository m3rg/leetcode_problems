/**
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

https://leetcode.com/problems/implement-strstr/
 */
package com.m3rg.leetcode_problems.easy;

public class _28_ImplementStrStr {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        _28_ImplementStrStr obj = new _28_ImplementStrStr();
        int result = obj.strStr(haystack, needle);
        System.out.println(result);
    }

    // Solution 1 - Brute Force
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] pattern = needle.toCharArray();
        char[] text = haystack.toCharArray();
        int maxLen = text.length - pattern.length;
        for (int i = 0; i <= maxLen; i++) {
            int j = 0;
            for (; j < pattern.length; j++) {
                char c = text[i + j];
                char n = pattern[j];
                if (c != n) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
        }
        return -1;
    }

    //Solution 2 - KMP Algorithm
    //Time Complexity: O(mn) m=haystack len n=needle len
    public int kmp(String haystack, String needle) {
        char[] pattern = needle.toCharArray();
        char[] text = haystack.toCharArray();
        int[] lps = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return i - j;
        }
        return -1;
    }

    public int[] computeTemporaryArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length;) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
