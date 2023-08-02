class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums: return [[]]
        res = []
        for i in range(len(nums)):
            for prev in self.permute(nums[:i] + nums[i + 1:]):
                res.append(prev + [nums[i]])
        return res
