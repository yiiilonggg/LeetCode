class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        dp = dict()
        for a in arr:
            dp[a] = 1 if a - difference not in dp else dp[a - difference] + 1
        return max(dp.values())
