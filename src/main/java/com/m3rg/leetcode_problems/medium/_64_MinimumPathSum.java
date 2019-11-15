/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

https://leetcode.com/problems/minimum-path-sum/
 */
package com.m3rg.leetcode_problems.medium;

public class _64_MinimumPathSum {

    public static void main(String[] args) {
        _64_MinimumPathSum obj = new _64_MinimumPathSum();
        int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int result = obj.minPathSum(grid);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[col - 1];
    }

    public int solution2(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
