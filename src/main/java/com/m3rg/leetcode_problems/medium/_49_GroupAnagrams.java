/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.

https://leetcode.com/problems/group-anagrams/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {

    public static void main(String[] args) {
        _49_GroupAnagrams obj = new _49_GroupAnagrams();
        List<List<String>> result = obj.groupAnagrams(new String[] { "tao", "pit", "cam", "aid", "pro", "dog" });
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String group = String.valueOf(chars);
            List<String> l = m.getOrDefault(group, new ArrayList<>());
            l.add(str);
            m.put(group, l);
        }
        return new ArrayList<>(m.values());
    }
}
