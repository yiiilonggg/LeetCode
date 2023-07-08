class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n, left, low, curr, total = len(nums), 1 if nums[0] >= target else 0, len(nums), 0, 0
        for right in range(n):
            curr += nums[right]
            while left < right and curr >= target:
                low = min(low, right - left + 1)
                cxurr -= nums[left]
                left += 1
            total += nums[right]
        while left < n and curr >= target:
            low = min(low, right - left + 1)
            curr -= nums[left]
            left += 1
        return low if total >= target else 0
