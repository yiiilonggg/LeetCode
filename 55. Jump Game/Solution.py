class Solution:
    def canJump(self, nums: List[int]) -> bool:
        high, curr, n = 0, 0, len(nums)
        while curr <= high:
            high = max(high, curr + nums[curr])
            curr += 1
            if high >= n - 1: return True
        return False
