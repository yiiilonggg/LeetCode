class Solution:
    def check(self, nums: List[int]) -> bool:
        if len(set(nums)) == 1: return True
        i, n = 1, len(nums)
        while i < n and nums[i] >= nums[i - 1]:
            i += 1
        if i == n: return True
        for j in range(i + 1, n):
            if nums[j] < nums[j - 1]: return False
        return nums[0] >= nums[-1]