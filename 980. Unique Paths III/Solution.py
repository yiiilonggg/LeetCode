class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        #return self.backtrackSolution(grid)
        return self.bitmaskSolution(grid)

    def initialiseVariables(self, grid, isBacktrackSolution):
        r, c = len(grid), len(grid[0])
        startRow, startCol, variable = 0, 0, 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == -1:
                    variable = variable + 1 if isBacktrackSolution else variable ^ (1 << (i * c + j))
                if grid[i][j] == 1: startRow, startCol = i, j
        return startRow, startCol, variable

    def backtrackSolution(self, grid):
        startRow, startCol, wallCount = self.initialiseVariables(grid, True)
        visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
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

    def bitmaskSolution(self, grid):
        startRow, startCol, mask = self.initialiseVariables(grid, False)
        return self.bitmask(startRow, startCol, mask, grid)
        
    def bitmask(self, currRow, currCol, mask, grid):
        if currRow < 0 or currRow >= len(grid) or currCol < 0 or currCol >= len(grid[0]): return 0
        if (mask & (1 << (currRow * len(grid[0]) + currCol))): return 0
        mask ^= (1 << (currRow * len(grid[0]) + currCol))
        if grid[currRow][currCol] == 2: return 1 if mask == ((1 << (len(grid) * len(grid[0]))) - 1) else 0
        return (self.bitmask(currRow + 1, currCol, mask, grid) +
                self.bitmask(currRow - 1, currCol, mask, grid) +
                self.bitmask(currRow, currCol + 1, mask, grid) +
                self.bitmask(currRow, currCol - 1, mask, grid))
