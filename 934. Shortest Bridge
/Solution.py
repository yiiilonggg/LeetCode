class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        self.r, self.c = len(grid), len(grid[0])
        self.q, self.grid, self.visited = [], grid, [[False for i in range(self.c)] for j in range(self.r)]
        self.moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        count = 0
        for i in range(self.r):
            for j in range(self.c):
                if grid[i][j] == 0: continue
                self.find(i, j)
                break
            if self.q: break
        while self.q:
            n = len(self.q)
            for i in range(n):
                x, y = self.q.pop(0)
                for a, b in self.moves:
                    nx, ny = x + a, y + b
                    if nx < 0 or ny < 0 or nx >= self.r or ny >= self.c: continue
                    if self.visited[nx][ny]: continue
                    if self.grid[nx][ny] == 1: return count
                    self.visited[nx][ny] = True
                    self.q.append((nx, ny))
            count += 1
        return -1
        
    def find(self, x, y):
        if x < 0 or y < 0 or x >= self.r or y >= self.c: return
        if self.visited[x][y] or self.grid[x][y] == 0: return
        self.visited[x][y] = True
        self.q.append((x, y))
        for a, b in self.moves:
            self.find(x + a, y + b)
