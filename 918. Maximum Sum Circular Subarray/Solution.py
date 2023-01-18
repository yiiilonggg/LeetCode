class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total, currMax, high, currMin, low = 0, 0, nums[0], 0, nums[0]
        for n in nums:
            total += n
            currMax = max(n, currMax + n)
            high = max(currMax, high)
            currMin = min(n, currMin + n)
            low = min(currMin, low)
        if high > 0: return max(high, total - low)
        return high