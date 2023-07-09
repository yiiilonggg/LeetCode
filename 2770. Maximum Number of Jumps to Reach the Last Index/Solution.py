class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        dp = [0 for i in range(n)]
        for i in range(n):
            if i > 0 and dp[i] == 0: continue
            for j in range(i + 1, n):
                if abs(nums[i] - nums[j]) <= target:
                    dp[j] = max(dp[j], dp[i] + 1)
        return -1 if dp[-1] == 0 else dp[-1]
