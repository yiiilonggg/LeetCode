class Solution:
    def minCost(self, nums: List[int], x: int) -> int:
        n = len(nums)
        res = [x * i for i in range(n)]
        for i in range(n):
            curr = nums[i]
            for j in range(n):
                curr = min(curr, nums[i - j])
                res[j] += curr
        return min(res)
