/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

https://leetcode.com/problems/permutations-ii/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII{

    public static void main(String[] args) {
        _47_PermutationsII obj = new _47_PermutationsII();
        List<List<Integer>> result = obj.permuteUnique(new int[]{1, 3, 1});
        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i< nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                backtrack(result, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
