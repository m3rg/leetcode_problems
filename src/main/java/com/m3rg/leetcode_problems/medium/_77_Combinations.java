/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

https://leetcode.com/problems/combinations/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

    public static void main(String[] args) {
        _77_Combinations obj = new _77_Combinations();
        List<List<Integer>> l = obj.combine(3, 2);
        System.out.println(l);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        if (k > n) {
            return l;
        }
        addToList(l, new ArrayList<>(), n, k, 1);
        return l;
    }

    public void addToList(List<List<Integer>> l, List<Integer> temp, int n, int k, int m) {
        if (k == 0) {
            l.add(new ArrayList<>(temp));
            return;
        }
        for (int i = m; i <= n + 1 - k; i++) {
            temp.add(i);
            addToList(l, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
