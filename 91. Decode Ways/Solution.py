class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0 for i in range(len(s) + 2)]
        dp[1] = 1
        for i in range(len(s)):
            dp[i + 2] = 0 if s[i] == '0' else dp[i + 1]
            if i > 0 and (s[i - 1] == '1' or (s[i - 1] == '2' and s[i] < '7')): dp[i + 2] += dp[i]
        return dp[-1]
