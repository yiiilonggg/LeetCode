import heapq
class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        pq = []
        for g in gifts:
            heapq.heappush(pq, -1 * g)
        for i in range(k):
            curr = -1 * heapq.heappop(pq)
            heapq.heappush(pq, -1 * (int)(curr ** 0.5))
        return -1 * sum(pq)