class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        mod = 10 ** 9 + 7
        dp = [0 for i in range(target + 1)]
        dp[0] = 1
        for x, y in types:
            for i in range(target, 0, -1):
                for j in range(1, x + 1):
                    if i - y * j < 0: break
                    dp[i] = (dp[i] + dp[i - y * j]) % mod
        return dp[target]