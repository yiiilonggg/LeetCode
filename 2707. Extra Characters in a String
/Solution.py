class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        dp = [0 for i in range(51)]
        for i in range(len(s) - 1, -1, -1):
            dp[i] = 1 + dp[i + 1]
            for d in dictionary:
                if s[i:i + len(d)] == d:
                    dp[i] = min(dp[i], dp[i + len(d)])
        return dp[0]
