class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0 for i in range(n)]
        res = 0
        for j in range(n):
            prevSmall = 0
            for i in range(j):
                if nums[j] > nums[i]:
                    prevSmall += 1
                    res += dp[i]
                else:
                    dp[i] += prevSmall
        return res