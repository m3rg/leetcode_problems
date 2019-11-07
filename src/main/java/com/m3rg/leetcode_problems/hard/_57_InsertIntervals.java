/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

https://leetcode.com/problems/insert-interval/
 */
package com.m3rg.leetcode_problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.m3rg.leetcode_problems.utils.ListUtils;

public class _57_InsertIntervals {

    public static void main(String[] args) {
        _57_InsertIntervals obj = new _57_InsertIntervals();
        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = new int[] { 4, 8 };
        int[][] result = obj.insert(intervals, newInterval);
        Integer[][] boxed = Arrays.stream(result).map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        ListUtils.printArray(boxed);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        for (int[] row : intervals) {
            if (isOverlap(row, newInterval)) {
                newInterval[0] = Math.min(newInterval[0], row[0]);
                newInterval[1] = Math.max(newInterval[1], row[1]);
            } else {
                l.add(row);
            }
        }
        l.add(newInterval);
        int[][] result = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        Arrays.sort(result, (a, b) -> a[0] - b[0]);
        return result;
    }

    private boolean isOverlap(int[] a, int[] b) {
        return !(a[1] < b[0] || a[0] > b[1]);
    }

    // Solution 2
    public int[][] solution2(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[][] { newInterval };
        }
        List<int[]> l = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            l.add(intervals[i]);
            i++;
        }
        // intersection
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        l.add(newInterval);
        // no intersection
        while (i < n) {
            l.add(intervals[i]);
            i++;
        }
        int[][] result = new int[l.size()][2];
        for (i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        return result;
    }
}
