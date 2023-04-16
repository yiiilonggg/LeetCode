class Solution:
    def findPrefixScore(self, nums: List[int]) -> List[int]:
        n, high = len(nums), nums[0]
        res = [0 for i in range(n)]
        res[0] = nums[0] + high
        for i in range(1, n):
            high = max(high, nums[i])
            conv = high + nums[i]
            res[i] = res[i - 1] + conv
        return res