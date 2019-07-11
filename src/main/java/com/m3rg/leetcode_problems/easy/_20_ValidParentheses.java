/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

Complexity analysis

Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.
Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.


 * https://leetcode.com/problems/valid-parentheses/submissions/
 */
package com.m3rg.leetcode_problems.easy;

import java.util.Stack;

public class _20_ValidParentheses {

    public static void main(String[] args) {
        String s = "()[()]{()}";
        _20_ValidParentheses obj = new _20_ValidParentheses();
        boolean result = obj.isValid(s);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                st.add(c);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                char popped = st.pop();
                if((c == ')' && popped != '(') ||
                    (c == '}' && popped != '{') ||
                    (c == ']' && popped != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
