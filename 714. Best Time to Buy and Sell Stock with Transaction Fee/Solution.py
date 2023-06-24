class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        dp = [[0 for i in range(n)] for j in range(2)]
        dp[0][0] -= prices[0]
        for i in range(1, n):
            dp[0][i] = max(dp[0][i - 1], dp[1][i - 1] - prices[i])
            dp[1][i] = max(dp[1][i - 1], dp[0][i - 1] + prices[i] - fee)
        
        return dp[1][-1]
