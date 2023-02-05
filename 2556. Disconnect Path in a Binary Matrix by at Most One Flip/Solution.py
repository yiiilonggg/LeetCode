class Solution:
    def isPossibleToCutPath(self, grid: List[List[int]]) -> bool:
        # return self.dfsSolution(grid)
        return self.diagonalSolution(grid)
    
    def dfsSolution(self, grid):
        self.m, self.n = len(grid), len(grid[0])
        if self.m * self.n == 2: return False
        visited = [[False for i in range(self.n)] for i in range(self.m)]
        if not self.dfs(grid, visited, 0, 0): return True
        return not self.dfs(grid, visited, 0, 0)

    def dfs(self, grid, visited, currX, currY):
        if currX == self.m - 1 and currY == self.n - 1: return True
        if grid[currX][currY] == 0: return False
        if not (currX == 0 and currY == 0) and visited[currX][currY]: return False
        visited[currX][currY] = True
        if currX + 1 < self.m and self.dfs(grid, visited, currX + 1, currY): return True
        if currY + 1 < self.n and self.dfs(grid, visited, currX, currY + 1): return True
        return False
    
    def diagonalSolution(self, grid):
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if (i == 0 and j == 0) or grid[i][j] == 0: continue
                if (i == 0 or grid[i - 1][j] == 0) and (j == 0 or grid[i][j - 1] == 0): grid[i][j] = 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if (i == m - 1 and j == n - 1) or grid[i][j] == 0: continue
                if (i == m - 1 or grid[i + 1][j] == 0) and (j == n - 1 or grid[i][j + 1] == 0): grid[i][j] = 0
        count = Counter([i + j for i in range(m) for j in range(n) if grid[i][j]])
        return any([count[i] < 2 for i in range(1, m + n - 2)])