/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

https://leetcode.com/problems/subsets/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    public static void main(String[] args) {
        _78_Subsets obj = new _78_Subsets();
        List<List<Integer>> result = obj.lexicographicSubset(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(result);
    }

    /**
     * Solution 1: Recursion Time complexity: O(N x 2^N ) to generate all subsets
     * and then copy them into output list. Space complexity: (2^N). This is exactly
     * the number of solutions for subsets. For a given number, it could be present
     * or absent (i.e. binary choice) in a subset solution. As as result, for NN
     * numbers, we would have in total 2^N choices (solutions).
     */
    public List<List<Integer>> recursion(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {
                    static final long serialVersionUID = 0L;
                    {
                        add(num);
                    }
                });

            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    /**
     * Solution 2: Backtrack Time complexity: O(Nx2^N) to generate all subsets and
     * then copy them into output list. Space complexity: (2^N) to keep all the
     * subsets, since each of n elements could be present or absent.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(l, new ArrayList<>(), nums, i, 0);
        }
        return l;
    }

    public void backtrack(List<List<Integer>> l, List<Integer> temp, int[] nums, int k, int m) {
        if (k == 0) {
            l.add(new ArrayList<>(temp));
        }
        for (int i = m; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(l, temp, nums, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Solution 3: Lexicographic Subset Time complexity: O(N x 2^N) to generate all
     * subsets and then copy them into output list. Space complexity: O(2^N) to keep
     * all the subsets, since each of n elements could be present or absent.
     */
    public List<List<Integer>> lexicographicSubset(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            System.out.println(i + ":" + Integer.toBinaryString(i) + ": " + bitmask);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            output.add(curr);
        }
        return output;
    }
}
