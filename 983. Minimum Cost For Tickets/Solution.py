class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0 for i in range(366)]
        t = set(days)
        for i in range(1, days[-1] + 1):
            if i in t:
                dp[i] = min(dp[i - 1] + costs[0], dp[max(0, i - 7)] + costs[1], dp[max(0, i - 30)] + costs[2])
            else:
                dp[i] = dp[i - 1]
        return dp[days[-1]]