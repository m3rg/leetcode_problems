/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"

https://leetcode.com/problems/count-and-say/
 */
package com.m3rg.leetcode_problems.easy;

public class _38_CountAndSay {

    public static void main(String[] args) {
        _38_CountAndSay obj = new _38_CountAndSay();
        String result = obj.countAndSay(3);
        System.out.println(result);
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = buildString(s);
        }
        return s;
    }

    public String buildString(String s) {
        int slen = s.length();
        StringBuilder sb = new StringBuilder();
        int similar = 1;
        for (int j = 0; j < slen - 1; j++) {
            char c = s.charAt(j);
            if (c == s.charAt(j + 1)) {
                similar++;
            } else {
                sb.append(similar).append(c);
                similar = 1;
            }
        }
        sb.append(similar).append(s.charAt(slen - 1));
        return sb.toString();
    }
}
