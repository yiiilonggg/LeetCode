class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        move = [ [0, 1], [0, -1], [1, 0], [-1, 0]]
        n, dist = len(grid), 0
        q = []
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1: q.append([i, j])
        if not q or len(q) == n * n: return -1
        while q:
            l = len(q)
            for i in range(l):
                x, y = q.pop(0)
                for a, b in move:
                    if x + a < 0 or x + a >= n or y + b < 0 or y + b >= n: continue
                    if grid[x + a][y + b] == 1: continue
                    grid[x + a][y + b] = 1
                    q.append([x + a, y + b])
            dist += 1
        return dist - 1