/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

O(n^3) time complexity, O(1) extra space complexity

https://leetcode.com/problems/4sum/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class _18_4Sum {
    
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2, 0, 0, 0, 0};
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
        int len = nums.length;
        if(nums == null || len < 4) {
            return result;
        }
        Arrays.sort(nums);
        int max = nums[len-1];
        if(4*nums[0] > target || 4*max < target) {
            return result;
        }
        for(int i = 0; i<len - 2; i++) {
            int z = nums[i];
            if(i > 0 && z == nums[i - 1]) {
                continue;
            }
            //z is too small, continue
            if(z + 3 * max < target) {
                continue;
            }
            //z is too large, no need to continue
            if(4 * z > target) {
                break;
            }
            //z is the boundary
            if(4 * z == target) {
                if(i + 3 < len && nums[i+3] == z) {
                    result.add(Arrays.asList(z, z, z, z));
                }
                break;
            }
            threeSum(result, nums, target-z, i+1, len-1, z);
        }
        return result;
    }

    private void threeSum(List<List<Integer>> result, int[] nums, int target, int lo, int hi, int z) {
        if(lo + 1 >= hi) {
            return;
        }
        if(3 * nums[lo] > target || 3 * nums[hi] < target) {
            return;
        }
        int max = nums[hi];
        for(int i = lo; i<hi-1; i++) {
            int z1 = nums[i];
            if(i > lo && z1 == nums[i-1]) {
                continue;
            }
            //z1 too small
            if(z1 + 2*max < target) {
                continue;
            }
            //z1 too small
            if(z1 * 3 > target) {
                break;
            }
            if(3 * z1 == target) {
                if(i+1 < hi && nums[i + 2] == z1) {
                    result.add(Arrays.asList(z, z1, z1, z1));
                }
                break;
            }
            twoSum(result, nums, target-z1, i+1, hi, z, z1);
        }
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int target, int lo, int hi, int z, int z1) {
        if(lo >= hi) {
            return;
        }
        if(2 * nums[lo] > target || 2 * nums[hi] < target) {
            return;
        }
        int sum, x;
        while(lo < hi) {
            sum = nums[lo] + nums[hi];
            if(sum == target) {
                result.add(Arrays.asList(z, z1, nums[lo], nums[hi]));
                x = nums[lo];
                while(++lo < hi && x == nums[lo]);
                x = nums[hi];
                while(lo < --hi && x == nums[hi]);
            } else if(sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }
}
