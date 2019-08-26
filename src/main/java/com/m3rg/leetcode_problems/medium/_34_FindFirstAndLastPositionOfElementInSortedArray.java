/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Time Ccomplexity: O(log n)
Space Complexity: O(1)

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
package com.m3rg.leetcode_problems.medium;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        _34_FindFirstAndLastPositionOfElementInSortedArray obj = new _34_FindFirstAndLastPositionOfElementInSortedArray();
        int[] result = obj
                .searchRange(new int[] { 0, 0, 0, 0, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 8, 9, 9, 10, 10, 11, 11 }, 0);
        ListUtils.printArray(result);

        result = obj.searchRange(new int[] { 2, 2 }, 2);
        ListUtils.printArray(result);
    }

    public int findIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] > target || (left && nums[m] == target)) {
                hi = m;
            } else {
                lo = m + 1;
            }
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums.length == 0) {
            return result;
        }
        int left = findIndex(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return result;
        }
        int right = findIndex(nums, target, false) - 1;
        result[0] = left;
        result[1] = right;
        return result;
    }
}
