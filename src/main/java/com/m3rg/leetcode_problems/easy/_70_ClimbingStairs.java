/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

https://leetcode.com/problems/climbing-stairs/
 */
package com.m3rg.leetcode_problems.easy;

public class _70_ClimbingStairs {

    public static void main(String[] args) {
        _70_ClimbingStairs obj = new _70_ClimbingStairs();
        int result = obj.fib(12);
        System.out.println(result);
    }

    // Solution 1, Brute Force, Time complexity : O(2^n). Size of recursion tree
    // will be 2^n
    public int bruteForce(int n) {
        return bruteForce(0, n);
    }

    public int bruteForce(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return bruteForce(i + 1, n) + bruteForce(i + 2, n);
    }

    // Solution 2, Recursion with Memoization,
    // Time complexity : O(n)
    // Space complexity : O(n)
    public int memoization(int n) {
        int[] memo = new int[n + 1];
        return memoization(0, n, memo);
    }

    public int memoization(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = memoization(i + 1, n, memo) + memoization(i + 2, n, memo);
        return memo[i];
    }

    // Solution 3, Dynamic Programming
    // Time complexity : O(n)
    // Space complexity : O(n)
    public int dp(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Solution 4, Fibonacci Number
    // Time complexity : O(n)
    // Space complexity : O(1)
    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
