package com.m3rg.leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        _3_LongestSubstring obj = new _3_LongestSubstring();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int j = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                j = Math.max(map.get(c), j);
            }
            ans = Math.max(ans, i - j + 1);
            map.put(c, i + 1);
        }
        return ans;
    }
}