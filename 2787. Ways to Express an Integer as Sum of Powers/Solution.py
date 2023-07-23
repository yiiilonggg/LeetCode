class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        powers = []
        curr, mod = 1, 1000000007
        while curr ** x <= n:
            powers.append(curr ** x)
            curr += 1
        p = len(powers)
        dp = [0 for i in range(n + 1)]
        dp[0] = 1
        for i in powers:
            for j in range(n, -1, -1):
                if j >= i:
                    dp[j] = (dp[j] + dp[j - i]) % mod
        return dp[-1]
