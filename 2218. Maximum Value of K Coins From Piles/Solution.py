class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)
        dp = [[0 for i in range(k + 1)] for j in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(k + 1):
                curr = 0
                for l in range(min(j, len(piles[i - 1])) + 1):
                    if l > 0: curr += piles[i - 1][l - 1]
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - l] + curr)
        return dp[n][k]