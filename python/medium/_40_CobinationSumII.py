'''
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

https://leetcode.com/problems/combination-sum-ii/
'''
from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        result = []
        self.backtrack(result, [], candidates, target, 0)
        return result

    def backtrack(self, result: List[List[int]], temp: List[int], candidates: List[int], remain: int, start: int) -> None:
        if remain == 0:
            result.append(temp.copy())
        else:
            for i in range(start, len(candidates)):
                if candidates[i] > remain:
                    break
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                self.backtrack(result, temp + [candidates[i]], candidates,
                               remain - candidates[i], i + 1)


obj = Solution()
result = obj.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
print(result)
