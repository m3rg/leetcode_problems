/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

https://leetcode.com/problems/3sum/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        _15_3Sum obj = new _15_3Sum();
        List<List<Integer>> result = obj.threeSum(nums);
        result.forEach(list -> {
            list.forEach(num -> System.out.print(num + ", "));
            System.out.println();
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i<len-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int sum = 0 - nums[i];
            int lo = i+1;
            int hi = len-1;
            while(lo < hi) {
                int twoSum = nums[lo] + nums[hi];
                if(twoSum == sum) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) {
                        lo++;
                    }
                    while(lo < hi && nums[hi] == nums[hi-1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if(twoSum > sum) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return result;
    }
}
