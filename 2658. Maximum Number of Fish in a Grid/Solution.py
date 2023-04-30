class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        r, c, high = len(grid), len(grid[0]), 0
        visited = [[False for i in range(c)] for j in range(r)]
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 0 or visited[i][j]: continue
                q = [[i, j]]
                visited[i][j] = True
                curr = 0
                while q:
                    x, y = q.pop(0)
                    curr += grid[x][y]
                    for a, b in moves:
                        nx, ny = x + a, y + b
                        if nx < 0 or ny < 0 or nx >= r or ny >= c: continue
                        if visited[nx][ny] or grid[nx][ny] == 0: continue
                        visited[nx][ny] = True
                        q.append([nx, ny])
                high = max(high, curr)
        return high