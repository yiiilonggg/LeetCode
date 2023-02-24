import heapq

class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        pq = []
        low, res = 2e10, 2e10
        for n in nums:
            if n % 2 == 1: n <<= 1
            low = min(low, n)
            heapq.heappush(pq, -n)
        while pq:
            curr = -heapq.heappop(pq)
            res = min(res, curr - low)
            if curr % 2 == 1: break
            low = min(low, curr >> 1)
            heapq.heappush(pq, -(curr >> 1))
        return res