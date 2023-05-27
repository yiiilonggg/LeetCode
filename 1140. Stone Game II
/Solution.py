class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        dp = [[[-1 for i in range(len(piles) + 1)] for j in range(len(piles) + 1)] for k in range(2)]
        return self.dfs(piles, dp, 0, 0, 1)
    def dfs(self, piles, dp, p, i, m):
        if i == len(piles): return 0
        if dp[p][i][m] != -1: return dp[p][i][m]
        res, s = 1000000 if p == 1 else -1, 0
        for x in range(1, min(2 * m, len(piles) - i) + 1):
            s += piles[i + x - 1]
            if p == 0:
                res = max(res, s + self.dfs(piles, dp, 1, i + x, max(m, x)))
            else:
                res = min(res, self.dfs(piles, dp, 0, i + x, max(m, x)))
        dp[p][i][m] = res
        return res
