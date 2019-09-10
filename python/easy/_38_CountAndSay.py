class Solution:
    def countAndSay(self, n: int) -> str:
        s = "1"
        for _ in range(1, n):
            s = self.buildString(s)
        return s

    def buildString(self, s: str) -> str:
        count = len(s)
        i = 0
        newS = ""
        while i < count:
            similar = 1
            i += 1
            while i < count and s[i] == s[i-1]:
                similar += 1
                i += 1
            newS += str(similar) + s[i-1]
        return newS


result = Solution().countAndSay(5)
print(result)
