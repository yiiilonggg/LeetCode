class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        self.n, self.m = len(grid), len(grid[0])
        self.g = grid
        self.moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        count = 0
        for i in range(self.n):
            for j in range(self.m):
                if self.g[i][j] == 1: continue
                if not self.dfs(i, j): count += 1
        return count
    
    def dfs(self, x, y):
        res = x == 0 or y == 0 or x == self.n - 1 or y == self.m - 1
        self.g[x][y] = 1
        for i, j in self.moves:
            nx, ny = x + i, y + j
            if nx < 0 or ny < 0 or nx >= self.n or ny >= self.m: continue
            if self.g[nx][ny] == 1: continue
            res |= self.dfs(nx, ny)
        return res