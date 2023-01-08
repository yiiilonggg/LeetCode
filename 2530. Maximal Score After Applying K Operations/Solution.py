import heapq

class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        pq = [-n for n in nums]
        heapify(pq)
        score = 0
        for i in range(k):
            curr = -heapq.heappop(pq)
            score += curr
            heapq.heappush(pq, -ceil(curr / 3))
        return score