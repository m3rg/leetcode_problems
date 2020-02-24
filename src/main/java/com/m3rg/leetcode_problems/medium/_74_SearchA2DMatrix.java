/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

https://leetcode.com/problems/search-a-2d-matrix/
 */
package com.m3rg.leetcode_problems.medium;

public class _74_SearchA2DMatrix {

    public static void main(String[] args) {
        _74_SearchA2DMatrix obj = new _74_SearchA2DMatrix();
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        boolean result = obj.solution2(matrix, 3);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int[] row = null;
        while (rowStart <= rowEnd) {
            int m = rowStart + (rowEnd - rowStart) / 2;
            if (target < matrix[m][0]) {
                rowEnd = m - 1;
            } else if (target > matrix[m][colEnd]) {
                rowStart = m + 1;
            } else {
                row = matrix[m];
                break;
            }
        }
        if (row == null) {
            return false;
        }
        while (colStart <= colEnd) {
            int m = colStart + (colEnd - colStart) / 2;
            if (target < row[m]) {
                colEnd = m - 1;
            } else if (target > row[m]) {
                colStart = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean solution2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
