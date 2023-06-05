class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        grad = lambda x, y: ((x[1] - y[1]), (x[0] - y[0]))
        dy, dx = grad(coordinates[0], coordinates[1])
        n = len(coordinates)
        for i in range(2, n):
            dyy, dxx = grad(coordinates[0], coordinates[i])
            if dx * dyy != dxx * dy: return False
        return True
