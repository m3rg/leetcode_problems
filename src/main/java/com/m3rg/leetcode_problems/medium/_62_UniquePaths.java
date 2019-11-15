/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28

https://leetcode.com/problems/unique-paths/
 */
package com.m3rg.leetcode_problems.medium;

public class _62_UniquePaths {

    public static void main(String[] args) {
        _62_UniquePaths obj = new _62_UniquePaths();
        int result = obj.uniquePaths(10, 10);
        System.out.println(result);
    }

    // Solution 1: Dynamic Programming
    // Reference: https://www.youtube.com/watch?v=GO5QHC_BmvM
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Solution 2: Naive Approach
    public int naive(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        return findPaths(m, n, 0, 0, "right") + findPaths(m, n, 0, 0, "down");
    }

    public int findPaths(int m, int n, int i, int j, String direction) {
        switch (direction) {
        case "right":
            if (i + 1 >= m) {
                return 0;
            }
            i++;
            break;
        case "down":
            if (j + 1 >= n) {
                return 0;
            }
            j++;
            break;
        }
        if (m == i + 1 && n == j + 1) {
            return 1;
        }
        return findPaths(m, n, i, j, "right") + findPaths(m, n, i, j, "down");
    }

    // Solution 3: Math Solution
    public int solution3(int m, int n) {
        int N = n + m - 2;
        int k = m - 1;
        double res = 1;
        for(int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }
}
