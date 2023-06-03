class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        moves = ((-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1), (-1, 0))
        n = len(grid)
        if grid[0][0] == 1 or grid[n - 1][n - 1] == 1: return -1
        if n == 1: return 1
        q = [(0, 0)]
        grid[0][0] = 1
        count = 0
        while q:
            l = len(q)
            count += 1
            for i in range(l):
                x, y = q.pop(0)
                if x == n - 1 and y == n - 1: return count
                for a, b in moves:
                    nx, ny = x + a, y + b
                    if nx < 0 or ny < 0 or nx >= n or ny >= n: continue
                    if grid[nx][ny] == 1: continue
                    grid[nx][ny] = 1
                    q.append((nx, ny))
        return -1
