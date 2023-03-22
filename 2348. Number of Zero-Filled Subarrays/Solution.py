class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        res, n, prev = 0, len(nums), -1
        for i in range(n):
            if nums[i] != 0:
                res += (i - prev) * (i - prev - 1) // 2
                prev = i
        res += (n - prev) * (n - prev - 1) // 2
        return res