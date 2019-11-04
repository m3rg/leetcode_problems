/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

https://leetcode.com/problems/jump-game/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.Arrays;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _55_JumpGame {

    public static void main(String[] args) {
        _55_JumpGame obj = new _55_JumpGame();
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        boolean result = obj.canJump(nums);
        ListUtils.printArray(nums);
        System.out.println(result);

        nums = new int[] { 3, 2, 1, 0, 4 };
        result = obj.canJump(nums);
        ListUtils.printArray(nums);
        System.out.println(result);
    }

    // Solution 1, Greedy
    // Time Complexity: O(n) Space Complexity: O(1)
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // Solution 2, Backtrack
    // Time Complexity: O(2^n) Space Complexity: O(n)
    public boolean backtrack(int[] nums) {
        return backtrack(0, nums);
    }

    private boolean backtrack(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (backtrack(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    // Solution 3, Dynamic Programming Top Down
    // Time Complexity: O(n^2) Space Complexity: O(2n) = O(n)
    public boolean dynamicTopDown(int[] nums) {
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[nums.length - 1] = Index.GOOD;
        return dynamicTopDown(0, nums);
    }

    private boolean dynamicTopDown(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (dynamicTopDown(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    // Solution 4, Dynamic Programming Bottom Up
    // Time Complexity: O(n^2) Space Complexity: O(n)
    public boolean dynamicBottomUp(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[nums.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
}
