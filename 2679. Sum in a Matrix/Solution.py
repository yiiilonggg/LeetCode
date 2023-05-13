import heapq

class Solution:
    def matrixSum(self, nums: List[List[int]]) -> int:
        r, c, res = len(nums), len(nums[0]), 0
        pqs = [[] for i in range(r)]
        for i in range(r):
            for j in range(c):
                heappush(pqs[i], -nums[i][j])
        for i in range(c):
            high = 0
            for j in range(r):
                high = max(high, -heappop(pqs[j]))
            res += high
        return res