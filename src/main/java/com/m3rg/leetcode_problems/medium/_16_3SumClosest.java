/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

https://leetcode.com/problems/3sum-closest/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.Arrays;

public class _16_3SumClosest {

    public static void main(String[] args) {
        int[] nums = {8, 1, 2,3,5,4,6,9,0,7};
        int target = 0;
        _16_3SumClosest obj = new _16_3SumClosest();
        int result = obj.threeSumClosest(nums, target);
        System.out.println(result);
    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i<len; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int lo = i+1;
            int hi = len-1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(sum-target) < diff) {
                    diff = Math.abs(sum-target);
                    result = sum;
                }
                if(sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return result;
    }
}
