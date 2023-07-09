class Solution:
    def checkArray(self, nums: List[int], k: int) -> bool:
        n, m = len(nums), 0
        for i in range(n):
            if nums[i] - m < 0: return False
            nums[i] -= m
            m += nums[i]
            if i >= k - 1: m -= nums[i - k + 1]
        return m == 0
