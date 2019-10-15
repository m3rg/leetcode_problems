'''
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

https://leetcode.com/problems/combination-sum/
'''
from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        result = []
        self.backtrack(result, [], candidates, target, 0)
        return result
    def backtrack(self, result: List[List[int]], temp: List[int], candidates: List[int], remain: int, start: int) -> None:
        if remain == 0:
            result.append(temp)
        else:
            for i, value in enumerate(candidates[start:]):
                if value > remain:
                    break
                self.backtrack(result, temp+[value], candidates, remain-value, start+i)

obj = Solution()
result = obj.combinationSum([2, 3, 6, 7], 7)
print(result)