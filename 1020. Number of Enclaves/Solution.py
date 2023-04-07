class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        self.g = grid
        self.n, self.m = len(grid), len(grid[0])
        res = 0
        for i in range(self.n):
            self.dfs(i, 0)
            self.dfs(i, self.m - 1)
        for i in range(self.m):
            self.dfs(0, i)
            self.dfs(self.n - 1, i)
        for i in range(1, self.n - 1):
            for j in range(1, self.m - 1):
                if self.g[i][j] == 0: continue
                res += self.dfs(i, j)
        return res

    def dfs(self, x, y):
        if x < 0 or y < 0 or x >= self.n or y >= self.m: return 0
        if self.g[x][y] == 0: return 0
        curr = 1
        self.g[x][y] = 0
        curr += self.dfs(x + 1, y)
        curr += self.dfs(x - 1, y)
        curr += self.dfs(x, y + 1)
        curr += self.dfs(x, y - 1)
        return curr