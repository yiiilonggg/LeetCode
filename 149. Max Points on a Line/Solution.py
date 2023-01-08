class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        high, INF, n = 1, float('inf'), len(points)
        for x1, y1 in points:
            counter = dict()
            for x2, y2 in points:
                if x1 == x2 and y1 == y2: continue
                dx, dy = x1 - x2, y1 - y2
                dydx = INF if dx == 0 else dy/dx
                if dydx not in counter: counter[dydx] = 0
                counter[dydx] += 1
            for k, v in counter.items():
                high = max(high, v + 1)
        return high