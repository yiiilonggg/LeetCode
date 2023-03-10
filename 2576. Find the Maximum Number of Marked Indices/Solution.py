class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums = sorted(nums)
        n = len(nums)
        front, back, res = 0, n // 2, 0
        while front < n // 2 and back < n:
            while back < n and nums[front] * 2 > nums[back]: back += 1
            if back < n: res += 2
            back += 1
            front += 1
        return res