/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Solution Two Pointers:
Time complexity: O(n). Single iteration of O(n).
Space complexity: O(1) extra space. Only constant space required for left, right, leftMax and rightMax.

https://leetcode.com/problems/trapping-rain-water/
 */
package com.m3rg.leetcode_problems.hard;

public class _42_TrappingRainWater {

    public static void main(String[] args) {
        _42_TrappingRainWater obj = new _42_TrappingRainWater();
        int result = obj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        System.out.println(result);
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    sum += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    sum += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
