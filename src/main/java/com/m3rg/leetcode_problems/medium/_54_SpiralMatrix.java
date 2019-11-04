/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

https://leetcode.com/problems/spiral-matrix/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {

    public static void main(String[] args) {
        _54_SpiralMatrix obj = new _54_SpiralMatrix();
        int[][] matrix = { { 1, 2, 3, 10, 17 }, { 4, 5, 6, 11, 18 }, { 7, 8, 9, 12, 19 }, { 13, 14, 15, 16, 20 } };
        List<Integer> result = obj.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        if (matrix.length == 0) {
            return l;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // left to right
            int i = colBegin;
            for (; i <= colEnd; i++) {
                l.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // up to down
            for (i = rowBegin; i <= rowEnd; i++) {
                l.add(matrix[i][colEnd]);
            }
            colEnd--;
            // right to left
            if (rowEnd >= rowBegin) {
                for (i = colEnd; i >= colBegin; i--) {
                    l.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // down to up
            if (colEnd >= colBegin) {
                for (i = rowEnd; i >= rowBegin; i--) {
                    l.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return l;
    }
}
