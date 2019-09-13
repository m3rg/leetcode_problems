/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

https://leetcode.com/problems/combination-sum-ii/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CobinationSumII {

    public static void main(String[] args) {
        _40_CobinationSumII obj = new _40_CobinationSumII();
        List<List<Integer>> result = obj.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > remain) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                // temp.add(candidates[i]);
                List<Integer> temp2 = new ArrayList<>(temp);
                temp2.add(candidates[i]);
                backtrack(result, temp2, candidates, remain - candidates[i], i + 1);
                // temp.remove(temp.size() - 1);
            }
        }
    }
}
