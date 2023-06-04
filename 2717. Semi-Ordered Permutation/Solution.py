class Solution:
    def semiOrderedPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        oneIdx, nIdx = -1, -1
        for i in range(n):
            if nums[i] == 1:
                oneIdx = i
            elif nums[i] == n:
                nIdx = i
        return oneIdx + (n - 1 - nIdx) if oneIdx < nIdx else oneIdx + (n - 1 - nIdx) - 1
