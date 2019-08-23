/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

https://leetcode.com/problems/longest-valid-parentheses/
 */
package com.m3rg.leetcode_problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class _32_LongestValidParentheses {

    public static void main(String[] args) {
        _32_LongestValidParentheses obj = new _32_LongestValidParentheses();
        int result = obj.longestValidParentheses("(())(())");
        System.out.println("Stack 1: " + result);

        System.out.println("Stack 2: " + obj.longestValidParentheses("(())))))))))))())()"));
        // Solution DP
        System.out.println("DP: " + obj.longestValidParenthesesDp("(())))))))))))())()"));
        // Solution Without Extra Space
        System.out.println("Without Extra Space: " + obj.withoutExtraSpace("(())(())"));
    }

    // Solution 1, Stack, Time Complexity: O(n), Space Complexity: O(n)
    public int longestValidParentheses(String s) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                q.add(i);
            } else {
                q.pollLast();
                if (!q.isEmpty()) {
                    max = Math.max(max, i - q.peekLast());
                } else {
                    q.add(i);
                }
            }
        }
        return max;
    }

    // Solution 2, DP, Time Complexity: O(n), Space Complexity: O(n)
    public int longestValidParenthesesDp(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    // Solution 3, Without extra space, Time Complexity: O(n), Space Complexity:
    // O(1)
    public int withoutExtraSpace(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return max;
    }
}
