class Solution:
    def numberOfGoodSubarraySplits(self, nums: List[int]) -> int:
        n, MOD, left, count = len(nums), 1000000007, -1, 0
        for i in range(n):
            if nums[i] == 1:
                if left != -1:
                    count = i - left if count == 0 else (count * (i - left)) % MOD
                left = i
        if count == 0 and left != -1: return 1
        return count
