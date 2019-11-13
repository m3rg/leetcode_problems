/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note:

    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"

https://leetcode.com/problems/permutation-sequence/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.LinkedList;

public class _60_PermutationSequence {

    public static void main(String[] args) {
        _60_PermutationSequence obj = new _60_PermutationSequence();
        String result = obj.getPermutation(5, 3);
        System.out.println(result);
    }

    public String getPermutation(int n, int k) {
        LinkedList<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    public String solution2(int n, int k) {
        LinkedList<Integer> notUsed = new LinkedList<Integer>();

        int weight = 1;

        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            if (i == n)
                break;
            weight = weight * i;
        }

        String res = "";
        k = k - 1;
        while (true) {
            res = res + notUsed.remove(k / weight);
            k = k % weight;
            if (notUsed.isEmpty())
                break;
            weight = weight / notUsed.size();
        }

        return res;
    }

    public String solution3(int n, int k) {
        k--;
        int fact = 1;
        char[] result = new char[n];
        result[n - 1] = '1';
        for (int i = 2; i <= n; i++) {
            fact *= i;
            result[n - i] = (char) (k % fact * i / fact + '1');
            for (int j = n - i + 1; j < n; j++) {
                result[j] += result[j] >= result[n - i] ? 1 : 0;
            }
            k -= k % fact;
        }
        return new String(result);
    }

}
