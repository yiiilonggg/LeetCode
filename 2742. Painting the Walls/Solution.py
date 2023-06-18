class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        n = len(cost)
        dp = [1000000007 for i in range(n + 1)]
        dp[0] = 0
        for c, t in zip(cost, time):
            for i in range(n, -1, -1):
                dp[min(i + t + 1, n)] = min(dp[min(i + t + 1, n)], dp[i] + c)
        return dp[n]
