/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"
-------------------------
 * EXPLANATION: https://www.youtube.com/watch?v=_nCsPn7_OgI
 * Time complexity: O ( n^2 )
 * Auxiliary Space: O ( n^2 )
 */
package com.m3rg.leetcode_problems.medium;

public class _5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "asdfaba";
        _5_LongestPalindromicSubstring obj = new _5_LongestPalindromicSubstring();
        String result = obj.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int len = s.length();
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}