class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        memo = [0 for i in range(len(nums) + 1)]
        memo[1] = nums[0]
        for i in range(1, len(nums)):
            memo[i + 1] = max(memo[i - 1] + nums[i], memo[i])
        return memo[len(nums)]
