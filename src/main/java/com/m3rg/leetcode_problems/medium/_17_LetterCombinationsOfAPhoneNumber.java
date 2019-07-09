/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

Complexity:
Time complexity : O(3^N×4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.
Space complexity : O(3^N×4^M) since one has to keep 3N×4M3^N \times 4^M3N×4M solutions.


https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber {

    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "23";
        _17_LetterCombinationsOfAPhoneNumber obj = new _17_LetterCombinationsOfAPhoneNumber();
        //Solution 1
        //List<String> result = obj.letterCombinations(digits);

        //Solution 2
        obj.recursive("", digits);
        List<String> result = obj.output;

        result.forEach(System.out::println);
    }

    //Solution 1
    public List<String> letterCombinations(String digits) {
        LinkedList<String> l = new LinkedList<>();
        
        l.add("");
        for(int i = 0; i<digits.length(); i++) {
            //int num = digits.charAt(i) - '0';
            int num = Character.getNumericValue(digits.charAt(i));
            char[] chars = mapping[num].toCharArray();
            while(l.peek().length() == i) {
                String t = l.remove();
                for(char s: chars) {
                    l.add(t + s);
                }
            }
        }
        return l;
    }

    //Solution 2
    List<String> output = new ArrayList<>();
    public void recursive(String combination, String nextDigits) {
        if(nextDigits.length() == 0) {
            output.add(combination);
        } else {
            //String digit = nextDigits.substring(0, 1);
            int digit = Character.getNumericValue(nextDigits.charAt(0));
            String letters = mapping[digit];
            for(int i = 0; i<letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                recursive(combination + letter, nextDigits.substring(1));
            }
        }
    }
}