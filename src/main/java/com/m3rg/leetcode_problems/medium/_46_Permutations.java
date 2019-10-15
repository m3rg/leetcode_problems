/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

https://leetcode.com/problems/permutations/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46_Permutations {

    public static void main(String[] args) {
        _46_Permutations obj = new _46_Permutations();
        List<List<Integer>> result = obj.permute(new int[] { 1, 2, 3 });
        System.out.println(result);
    }

    // Solution 1: Backtrack
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(result, temp, nums, start + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // Solotion 2: iterative
    public List<List<Integer>> iterative(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (; size > 0; size--) {
                List<Integer> r = result.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    result.add(t);
                }
            }
        }
        return result;
    }

    // Solution 3: Without additional Space
    public List<List<Integer>> solution3(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(result, num, 0);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] array, int start) {
        if (start >= array.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permute(result, array, start + 1);
                swap(array, start, i);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }
}
