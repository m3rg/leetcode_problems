/**
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

https://leetcode.com/problems/merge-intervals/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _56_MergeIntervals {

    public static void main(String[] args) {
        _56_MergeIntervals obj = new _56_MergeIntervals();
        int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = obj.merge(intervals);
        Integer[][] boxed = Arrays.stream(result).map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        ListUtils.printArray(boxed);
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> l = new ArrayList<>();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || start[i + 1] > end[i]) {
                l.add(new int[] { start[startIndex], end[i] });
                startIndex = i + 1;
            }
        }
        int[][] result = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            result[i][0] = l.get(i)[0];
            result[i][1] = l.get(i)[1];
        }
        return result;
    }
}
