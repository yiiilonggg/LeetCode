class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        movements = [[2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]
        q = [[0, 0]]
        depth, n = 0, len(grid)
        while q:
            l = len(q)
            for i in range(l):
                x, y = q.pop(0)
                if grid[x][y] != depth: continue
                if grid[x][y] == n * n - 1: return True
                for a, b in movements:
                    nx, ny = x + a, y + b
                    if nx < 0 or ny < 0 or nx >= n or ny >= n: continue
                    q.append([nx, ny])
            depth += 1
        return False