class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        s, n = sorted(nums), len(nums)
        low = 1000000000
        for i in range(1, n):
            low = min(low, s[i] - s[i - 1])
        return low
