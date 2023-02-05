class Solution:
    def maximizeWin(self, prizePositions: List[int], k: int) -> int:
        n, left, res = len(prizePositions), 0, 0
        dp = [0 for i in range(n + 1)]
        for right in range(n):
            while prizePositions[right] - prizePositions[left] > k: left += 1
            dp[right + 1] = max(dp[right], right - left + 1)
            res = max(res, dp[left] + right - left + 1)
        return res