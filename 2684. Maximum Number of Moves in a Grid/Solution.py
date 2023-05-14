class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        q = []
        r, c, high = len(grid), len(grid[0]), 0
        for i in range(r): q.append([i, 0])
        while q and q[0][1] < c - 1:
            col = [False for i in range(r)]
            l = len(q)
            for i in range(l):
                x, y = q.pop(0)
                for j in range(-1, 2):
                    if x + j < 0 or x + j >= r: continue
                    if grid[x][y] >= grid[x + j][y + 1]: continue
                    if col[x + j]: continue
                    q.append([x + j, y + 1])
                    col[x + j] = True
            if q: high += 1
        return high