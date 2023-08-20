import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = []
        for n in nums:
            heappush(pq, n)
            if len(pq) > k: heappop(pq)
        return heappop(pq)
