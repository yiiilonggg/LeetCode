class Solution:
    def findNonMinOrMax(self, nums: List[int]) -> int:
        if len(nums) <= 2: return -1
        high, low = max(nums), min(nums)
        for n in nums:
            if n != high and n != low: return n
