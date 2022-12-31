class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        r, c = len(grid), len(grid[0])
        visited = [[False for j in range(c)] for i in range(r)]
        startRow, startCol, wallCount = 0, 0, 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == -1: wallCount += 1
                if grid[i][j] == 1: startRow, startCol = i, j
        return self.backtrack(startRow, startCol, grid, wallCount, visited)
    
    def backtrack(self, currRow, currCol, grid, currCount, visited):
        if currRow < 0 or currRow >= len(grid) or currCol < 0 or currCol >= len(grid[0]): return 0
        if visited[currRow][currCol] or grid[currRow][currCol] == -1: return 0
        if grid[currRow][currCol] == 2: return 1 if currCount + 1 == len(grid) * len(grid[0]) else 0
        currCount += 1
        visited[currRow][currCol] = True
        paths = (self.backtrack(currRow + 1, currCol, grid, currCount, visited) +
                self.backtrack(currRow - 1, currCol, grid, currCount, visited) +
                self.backtrack(currRow, currCol + 1, grid, currCount, visited) +
                self.backtrack(currRow, currCol - 1, grid, currCount, visited))
        visited[currRow][currCol] = False
        return paths
