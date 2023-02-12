class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums = sorted(nums)
        return self.countLess(nums, upper + 1) - self.countLess(nums, lower)
    
    def countLess(self, nums, val):
        res, left, right = 0, 0, len(nums) - 1
        while left < right:
            while left < right and nums[left] + nums[right] >= val: right -= 1
            res += right - left
            left += 1
        return res