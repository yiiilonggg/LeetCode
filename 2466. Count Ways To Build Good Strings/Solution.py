class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        dp = [0 for i in range(high + 1)]
        dp[0] = 1
        res, mod = 0, 1e9 + 7
        for i in range(1, high + 1):
            if i - zero >= 0: dp[i] += dp[i - zero]
            if i - one >= 0: dp[i] += dp[i - one]
            dp[i] %= mod
            if i >= low: res = (dp[i] + res) % mod
        return int(res)