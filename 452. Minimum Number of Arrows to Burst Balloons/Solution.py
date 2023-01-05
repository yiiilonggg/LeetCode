class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points = sorted(points, key = lambda x: x[1])
        currMax, arrows = points[0][1], 1
        for i in range(1, len(points)):
            if currMax >= points[i][0]: continue
            arrows += 1
            currMax = points[i][1]
        return arrows