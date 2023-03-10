class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [i for i in nums]
        for i in range(1, n):
            prefix[i] += prefix[i - 1]
        return [abs((prefix[i] - nums[i]) - (prefix[-1] - prefix[i])) for i in range(n)]