import heapq

class Solution:
    def minimumCost(self, start: List[int], target: List[int], specialRoads: List[List[int]]) -> int:
        s, res = len(specialRoads), self.comp(start[0], target[0], start[1], target[1])
        dist = [self.comp(start[0], specialRoads[i][0], start[1], specialRoads[i][1]) + specialRoads[i][4] for i in range(s)]
        pq = []
        for i in range(s):
            heapq.heappush(pq, (dist[i], i))
        while pq:
            d, c = heapq.heappop(pq)
            if d != dist[c]: continue
            res = min(res, d + self.comp(specialRoads[c][2], target[0], specialRoads[c][3], target[1]))
            for i in range(s):
                b = self.comp(specialRoads[c][2], specialRoads[i][0], specialRoads[c][3], specialRoads[i][1]) + specialRoads[i][4]
                if b + d < dist[i]:
                    dist[i] = b + d
                    heapq.heappush(pq, (dist[i], i))
        return res

    def comp(self, a, b, c, d):
        return abs(a - b) + abs(c - d)