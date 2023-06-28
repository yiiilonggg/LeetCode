import heapq

class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        res, n, left, right = 0, len(costs), 0, len(costs) - 1
        pq = []
        while left < candidates:
            heappush(pq, (costs[left], -1))
            left += 1
        while right >= max(left, n - candidates):
            heappush(pq, (costs[right], 1))
            right -= 1
        for i in range(k):
            if not pq: break
            c, s = heappop(pq)
            res += c
            if left > right: continue
            if s == -1:
                heappush(pq, (costs[left], -1))
                left += 1
            else:
                heappush(pq, (costs[right], 1))
                right -= 1
        return res
