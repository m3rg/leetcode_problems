/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

https://leetcode.com/problems/spiral-matrix-ii/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.Arrays;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _59_SpiralMatrixII {

    public static void main(String[] args) {
        _59_SpiralMatrixII obj = new _59_SpiralMatrixII();
        int[][] result = obj.generateMatrix(6);
        Integer[][] boxed = Arrays.stream(result).map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        ListUtils.printArray(boxed);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // left to right
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = ++num;
            }
            rowBegin++;
            // up to down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = ++num;
            }
            colEnd--;
            // right to left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = ++num;
                }
            }
            rowEnd--;
            // down to up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = ++num;
                }
            }
            colBegin++;
        }
        return matrix;
    }
}
