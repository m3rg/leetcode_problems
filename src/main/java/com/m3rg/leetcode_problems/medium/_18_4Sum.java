package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class _18_4Sum {
    
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        _18_4Sum obj = new _18_4Sum();
        List<List<Integer>> result = obj.fourSum(nums, target);
        result.forEach(l -> {
            StringJoiner sj = new StringJoiner(", ");
            l.forEach(num -> sj.add(String.valueOf(num)));
            System.out.println(sj.toString());
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 2; i++) {
            
        }
        return result;
    }
}