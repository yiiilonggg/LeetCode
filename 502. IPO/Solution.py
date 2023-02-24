import heapq

class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        n, pointer = len(profits), 0
        combined, pq = sorted(list(zip(capital, profits)), key = itemgetter(0)), []
        for i in range(k):
            while pointer < n and combined[pointer][0] <= w:
                heapq.heappush(pq, -combined[pointer][1])
                pointer += 1
            if not pq: break
            w -= heapq.heappop(pq)
        return w