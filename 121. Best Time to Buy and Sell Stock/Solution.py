class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n, high, res = len(prices), prices[-1], 0
        for i in range(n - 1, -1, -1):
            res = max(res, high - prices[i])
            high = max(high, prices[i])
        return res