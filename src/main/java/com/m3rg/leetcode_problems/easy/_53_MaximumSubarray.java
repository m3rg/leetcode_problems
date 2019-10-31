/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Time Complexity: O(n)
Space Complexity: O(1)

https://leetcode.com/problems/maximum-subarray/
 */
package com.m3rg.leetcode_problems.easy;

public class _53_MaximumSubarray {

    public static void main(String[] args) {
        _53_MaximumSubarray obj = new _53_MaximumSubarray();
        int result = obj.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, 1, 3 });
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
