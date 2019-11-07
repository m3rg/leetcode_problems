/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

https://leetcode.com/problems/length-of-last-word/
 */
package com.m3rg.leetcode_problems.easy;

public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        _58_LengthOfLastWord obj = new _58_LengthOfLastWord();
        int result = obj.lengthOfLastWord("Hello World");
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
