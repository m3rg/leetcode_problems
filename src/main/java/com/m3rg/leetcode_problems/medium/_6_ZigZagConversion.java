/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
package com.m3rg.leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class _6_ZigZagConversion {

    public static void main(String[] args) {
        String s = "ABCDEFG";
        int numRows = 2;
        _6_ZigZagConversion obj = new _6_ZigZagConversion();
        //String result = obj.convert(s, numRows);
        String result = obj.visitByRow(s, numRows);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if(numRows <= 0) {
            return s;
        }
        Map<Integer, StringBuilder> m = new HashMap<>();
        char[] chars = s.toCharArray();
        int inc = 1;
        int index = 0;
        for(char c: chars) {
            if(index == numRows-1) {
                inc = -1;
            }
            else if(index == 0) {
                inc = 1;
            }
            if(numRows == 1) {
                inc = 0;
            }
            
            StringBuilder sb = m.get(index);
            if(sb == null) {
                sb = new StringBuilder();
            }
            sb.append(c);
            m.put(index, sb);
            index += inc;
        }
        m.forEach((a, b) -> System.out.println(a + "- " + b.toString()));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=numRows; i++) {
            if(m.containsKey(i)) {
                sb.append(m.get(i).toString());
            }
        }
        return sb.toString();
    }

    // Approach 2
    public String visitByRow(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}