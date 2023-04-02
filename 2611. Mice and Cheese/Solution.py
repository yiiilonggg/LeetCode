import heapq

class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        pq = []
        combined = list(zip(reward1, reward2))
        res = 0
        for x, y in combined:
            heapq.heappush(pq, (-(x - y), x, y))
        for i in range(k):
            res += heapq.heappop(pq)[1]
        for i in range(len(combined) - k):
            res += heapq.heappop(pq)[2]
        return res

    def miceAndCheeseSorting(self, reward1: List[int], reward2: List[int], k: int) -> int:
        combined = sorted(list(zip(reward1, reward2)), key = lambda x: x[1] - x[0])
        res = 0
        for i in range(k):
            res += combined[i][0]
        for i in range(k, len(reward1)):
            res += combined[i][1]
        return res