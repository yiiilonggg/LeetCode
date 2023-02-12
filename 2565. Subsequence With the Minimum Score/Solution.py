class Solution:
    def minimumScore(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        left, right = 0, n - 1
        dp = [0 for i in range(m)]
        for i in range(m):
            if left < n and s[i] == t[left]: left += 1
            dp[i] = left
        res = n - left
        for i in range(m - 1, -1, -1):
            res = min(res, max(0, right - dp[i] + 1))
            if right > 0 and s[i] == t[right]: right -= 1
        return min(res, right + 1)