import heapq

class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        pq = []
        res, count = 1, 0
        for n in nums:
            if n >= 1:
                res *= n
                count += 1
            else:
                heappush(pq, n)
        while len(pq) > 1:
            curr = heappop(pq)
            if curr < 0:
                if pq[0] < 0:
                    res *= curr * heappop(pq)
                    count += 2
                else:
                    if count == 0: res = 0
            else:
                if count == 0: res = 0
        return res
