/**
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Complexity Analysis

Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n). This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number 1n+1(2nn)\dfrac{1}{n+1}\binom{2n}{n}n+11​(n2n​), which is bounded asymptotically by 4nnn\dfrac{4^n}{n\sqrt{n}}nn

​4n​.

    Time Complexity : O{4^n}/{sqrt(n)}

    Each valid sequence has at most n steps during the backtracking procedure.

Space Complexity : O{4^n}/{sqrt(n)}
as described above, and using O(n) space to store the sequence. 

Explanation: The way I like to think about the runtime of backtracking algorithms is O(b^d), where b is the branching factor and d is the maximum depth of recursion.

Backtracking is characterized by a number of decisions b that can be made at each level of recursion. If you visualize the recursion tree, this is the number of children each internal node has. You can also think of b as standing for "base", which can help you remember that b is the base of the exponential.

If we can make b decisions at each level of recursion, and we expand the recursion tree to d levels (ie: each path has a length of d), then we get b^d nodes. Since backtracking is exhaustive and must visit each one of these nodes, the runtime is O(b^d).

https://leetcode.com/problems/generate-parentheses/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        _22_GenerateParentheses obj = new _22_GenerateParentheses();
        List<String> result = obj.generateParenthesis(n);
        //List<String> result = obj.closureNumber(n);
        //List<String> result = obj.iterative(n);
        result.forEach(System.out::println);
    }

    //Solution 1 Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    //Solution 1 Backtracking
    public void dfs(List<String> result, String s, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if(left > 0) {
            dfs(result, s+"(", left-1, right);
        }
        if(right > 0) {
            dfs(result, s+")", left, right-1);
        }
    }

    //Solution 2 Closure Number
    public List<String> closureNumber(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            result.add("");
        } else {
            for(int c = 0; c < n; c++) {
                for(String left: closureNumber(c)) {
                    for(String right: closureNumber(n-1-c)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return result;
    }

    //Solution 3 Iterative
    public List<String> iterative(int n) {
        List<String> result = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();
        result.add("");
        diff.add(0);
        for(int i = 0; i < 2 * n; i++) {
            List<String> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            for(int j = 0; j<result.size(); j++) {
                String s = result.get(j);
                int k = diff.get(j);
                if(i < 2 * n - 1) {
                    temp1.add(s + "(");
                    temp2.add(k + 1);
                }
                if(k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n -1) {
                    temp1.add(s + ")");
                    temp2.add(k - 1);
                }
            }
            result = new ArrayList<>(temp1);
            diff = new ArrayList<>(temp2);
        }
        return result;
    }

}