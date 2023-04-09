class Solution:
    def minimumVisitedCells(self, grid: List[List[int]]) -> int:
        q = [[0, 0]]
        n, m, steps = len(grid), len(grid[0]), 1
        if n == 1 and m == 1: return 1
        visited = [[False for i in range(m)] for j in range(n)]
        while q:
            l = len(q)
            for i in range(l):
                x, y = q.pop(0)
                for i in range(1, grid[x][y] + 1):
                    nx, ny = x + i, y + i
                    if (nx == n - 1 and y == m - 1) or (x == n - 1 and ny == m - 1): return steps + 1
                    if nx < n and not visited[nx][y] and grid[nx][y] > 0:
                        visited[nx][y] = True
                        q.append([nx, y])
                    if ny < m and not visited[x][ny] and grid[x][ny] > 0:
                        visited[x][ny] = True
                        q.append([x, ny])
            steps += 1
        return -1