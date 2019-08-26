/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 4:

Input: [1,3,5,6], 0
Output: 0

https://leetcode.com/problems/search-insert-position/
 */
package com.m3rg.leetcode_problems.easy;

public class _35_SearchInsertPosition {

    public static void main(String[] args) {
        _35_SearchInsertPosition obj = new _35_SearchInsertPosition();
        int result = obj.searchInsert(new int[] { 1, 3, 5, 6 }, 5);
        System.out.println(result);

        result = obj.searchInsert(new int[] { 1, 3, 5, 6 }, 2);
        System.out.println(result);

        result = obj.searchInsert(new int[] { 1, 3, 5, 6 }, 7);
        System.out.println(result);

        result = obj.searchInsert(new int[] { 1, 3, 5, 6 }, 0);
        System.out.println(result);

        result = obj.searchInsert(new int[] {}, 5);
        System.out.println(result);

        result = obj.searchInsert(new int[] { 0, 0, 1, 1, 1, 1, 3, 3, 3, 3, 8 }, 1);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2; // low<=mid, mid<high
            if (nums[m] >= target) {
                hi = m; // high always decreases (even high-low==1)
            } else {
                lo = m + 1; // low always increases
            }
        }
        return lo;
    }
}
