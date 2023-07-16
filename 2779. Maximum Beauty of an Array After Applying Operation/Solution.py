class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums.sort()
        left, right, n, high = 0, 0, len(nums), 0
        while right < n:
            while left < right and nums[right] - nums[left] > 2 * k: left += 1
            while right < n and nums[right] - nums[left] <= 2 * k: right += 1
            high = max(high, right - left)
        return high
