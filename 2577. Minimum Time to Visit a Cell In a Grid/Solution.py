# credit to: tojuna
import heapq
class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        if grid[0][1] > 1 and grid[1][0] > 1: return -1
        n, m = len(grid), len(grid[0])
        visited = [[False for i in range(m)] for j in range(n)]
        pq = [(grid[0][0], 0, 0)]
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while pq:
            time, x, y = heapq.heappop(pq)
            if x == n - 1 and y == m - 1: return time
            if visited[x][y]: continue
            visited[x][y] = True
            for r, c in directions:
                nr, nc = x + r, y + c
                if nr < 0 or nr >= n or nc < 0 or nc >= m: continue
                if visited[nr][nc]: continue
                wait = 1 if (grid[nr][nc] - time) % 2 == 0 else 0
                heappush(pq, (max(time + 1, grid[nr][nc] + wait), nr, nc))
        return -1