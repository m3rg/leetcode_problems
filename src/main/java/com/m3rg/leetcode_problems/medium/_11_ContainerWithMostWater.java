/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

Complexity Analysis
Time complexity : O(n). Single pass.
Space complexity : O(1). Constant space is used.

https://leetcode.com/problems/container-with-most-water/
 */
package com.m3rg.leetcode_problems.medium;

public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        _11_ContainerWithMostWater obj = new _11_ContainerWithMostWater();
        int result = obj.maxArea(height);
        System.out.println(result);
        System.out.println(2/1000);
    }

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            int width = j - i;
            if(height[i] < height[j]) {
                max = Math.max(max, height[i] * width);
                i++;
            } else {
                max = Math.max(max, height[j] * width);
                j--;
            }
        }
        return max;
    }
}