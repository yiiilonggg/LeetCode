class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        nums = sorted(nums)
        high, low = nums[-1], nums[0]
        return min(high - nums[2], nums[-3] - low, nums[-2] - nums[1])