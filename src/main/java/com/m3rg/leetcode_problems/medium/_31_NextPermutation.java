/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

Complexity Analysis
Time complexity : O(n). In worst case, only two scans of the whole array are needed.
Space complexity : O(1). No extra space is used. In place replacements are done.

Steps:
1. Find the first decreasing element from the end.
2. Find the first larger element than the decreasing element
3. Swamp those two elements.
4. Reverse the rest

https://leetcode.com/problems/next-permutation/
 */
package com.m3rg.leetcode_problems.medium;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        _31_NextPermutation obj = new _31_NextPermutation();
        obj.nextPermutation(nums);
        ListUtils.printArray(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
