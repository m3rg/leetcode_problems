/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
package com.m3rg.leetcode_problems.medium;

public class _33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        _33_SearchInRotatedSortedArray obj = new _33_SearchInRotatedSortedArray();
        int result = obj.search(new int[] { 4, 5, 6, 7, 8, 9, 0, 1, 2 }, 0);
        System.out.println(result);

        result = obj.search(new int[] {}, 5);
        System.out.println(result);

        result = obj.search(new int[] { 0, 2, 3 }, 3);
        System.out.println(result);
        // --------------
        result = obj.solution2(new int[] { 4, 5, 6, 7, 8, 9, 0, 1, 2 }, 0);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pivot = findPivot(nums, 0, nums.length - 1);
        int index = find(nums, target, 0, pivot);
        if (index > -1) {
            return index;
        }
        return find(nums, target, pivot + 1, nums.length - 1);
    }

    public int find(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int m = lo + (hi - lo) / 2;
        if (target < nums[m]) {
            return find(nums, target, lo, m - 1);
        } else if (target > nums[m]) {
            return find(nums, target, m + 1, hi);
        }
        return m;
    }

    public int findPivot(int nums[], int lo, int hi) {
        int m = lo + (hi - lo) / 2;
        if (nums[m] > nums[lo] && nums[m] > nums[hi]) {
            return findPivot(nums, m, hi);
        } else if (nums[m] < nums[lo] && nums[m] < nums[hi]) {
            return findPivot(nums, lo, m);
        }
        return m;
    }

    // Solution 2
    public int solution2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
