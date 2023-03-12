class Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums = sorted(nums, reverse = True)
        prefix = nums[0]
        if prefix <= 0: return 0
        for count in range(1, len(nums)):
            prefix += nums[count]
            if prefix <= 0: break
        return len(nums) if prefix > 0 else count