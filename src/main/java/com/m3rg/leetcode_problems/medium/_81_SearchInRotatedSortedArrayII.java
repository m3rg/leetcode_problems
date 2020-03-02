/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28216/Java-1ms-binary-search-solution-with-comments
 */
package com.m3rg.leetcode_problems.medium;

public class _81_SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        _81_SearchInRotatedSortedArrayII obj = new _81_SearchInRotatedSortedArrayII();
        // boolean result = obj.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0);
        boolean result = obj.search(new int[] { }, 0);
        System.out.println(result);
    }

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else { // have no idea about the array, but we can exclude nums[start] because
                     // nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
}
