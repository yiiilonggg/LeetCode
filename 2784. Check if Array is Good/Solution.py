class Solution:
    def isGood(self, nums: List[int]) -> bool:
        high = max(nums)
        if len(nums) != high + 1: return False
        counter = [0 for i in range(high + 1)]
        for n in nums: counter[n] += 1
        for i in range(1, high):
            if counter[i] != 1: return False
        return counter[high] == 2
