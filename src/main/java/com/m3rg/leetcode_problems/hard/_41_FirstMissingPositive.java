/**
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:

Your algorithm should run in O(n) time and uses constant extra space.

https://leetcode.com/problems/first-missing-positive/
 */
package com.m3rg.leetcode_problems.hard;

public class _41_FirstMissingPositive {

    public static void main(String[] args) {
        _41_FirstMissingPositive obj = new _41_FirstMissingPositive();
        int[] nums = { -45, 8, -9, 2, 7 };
        int result = obj.solution2(nums);
        System.out.println(result);
    }

    public int firstMissingPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = nums[start] - 1;
            if (index == start) {
                start++;
            } else if (index < 0 || index > end || nums[start] == nums[index]) {
                nums[start] = nums[end--];
            } else {
                nums[start] = nums[index];
                nums[index] = index + 1;
            }
        }
        return start + 1;
    }

    public int solution2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 1;
        }
        int k = partition(nums) + 1;
        int temp = 0;
        int firstMissingIndex = k;
        for (int i = 0; i < k; i++) {
            temp = Math.abs(nums[i]);
            if (temp <= k) {
                nums[temp - 1] = nums[temp - 1] < 0 ? nums[temp - 1] : -nums[temp - 1];
            }
        }
        for (int i = 0; i < k; i++) {
            if (nums[i] > 0) {
                firstMissingIndex = i;
                break;
            }
        }
        return firstMissingIndex + 1;
    }

    private int partition(int[] nums) {
        int n = nums.length;
        int q = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                q++;
                swamp(nums, q, i);
            }
        }
        return q;
    }

    private void swamp(int nums[], int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
