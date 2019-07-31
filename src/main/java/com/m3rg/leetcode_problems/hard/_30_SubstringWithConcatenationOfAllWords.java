/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []

https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
package com.m3rg.leetcode_problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        // String s = "wordgoodgoodgoodbestword";
        // String[] words = { "word","good","best","good" };
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = { "fooo", "barr", "wing", "ding", "wing" };
        _30_SubstringWithConcatenationOfAllWords obj = new _30_SubstringWithConcatenationOfAllWords();
        List<Integer> result = obj.findSubstring(s, words);
        System.out.println(result);
    }

    //Solution 1, Two Pointers
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int len = words[0].length();

        for (int j = 0; j < len; j++) {
            Map<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;// start index of start
            int count = 0;// count totoal qualified words so far

            for (int i = j; i <= s.length() - len; i = i + len) {
                String sub = s.substring(i, i + len);
                if (map.containsKey(sub)) {
                    // set frequency in current map
                    currentMap.put(sub, currentMap.getOrDefault(sub, 0) + 1);

                    count++;

                    while (currentMap.get(sub) > map.get(sub)) {
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);

                        count--;
                        start = start + len;
                    }

                    if (count == words.length) {
                        result.add(start); // add to result

                        // shift right and reset currentMap, count & start point
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }
                } else {
                    currentMap.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }
        return result;
    }

    // Solution 2, Iterative Hash Map
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordsLen = words.length;
        if (wordsLen == 0 || s.length() == 0) {
            return result;
        }
        int len = words[0].length();
        int totalLen = len * wordsLen;
        if (s.length() < totalLen) {
            return result;
        }
        Map<String, Integer> wordsMap = new HashMap<>(wordsLen);
        for (String word : words) {
            int count = wordsMap.getOrDefault(word, 0) + 1;
            wordsMap.put(word, count);
        }
        for (int i = 0; i <= s.length() - totalLen; i += len) {
            boolean success = true;
            Map<String, Integer> tmpWords = new HashMap<>(wordsMap);
            for (int j = i; j < i + totalLen; j += len) {
                String sub = s.substring(j, j + len);
                int count = tmpWords.getOrDefault(sub, 0);
                if (count == 0) {
                    success = false;
                    break;
                }
                if (count == 1) {
                    tmpWords.remove(sub);
                } else {
                    tmpWords.put(sub, count - 1);
                }
            }
            if (success && tmpWords.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }
}
