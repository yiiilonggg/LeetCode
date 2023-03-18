import heapq

class Solution:
    def findScore(self, nums: List[int]) -> int:
        n, res = len(nums), 0
        pq = []
        for i in range(n): heapq.heappush(pq, (nums[i], i))
        marked = [False for i in range(n)]
        while pq:
            x, i = heapq.heappop(pq)
            if marked[i]: continue
            marked[i] = True
            res += x
            if i > 0: marked[i - 1] = True
            if i < n - 1: marked[i + 1] = True
        return res