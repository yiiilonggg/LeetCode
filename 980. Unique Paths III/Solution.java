class Solution {
    public int uniquePathsIII(int[][] grid) {
        //return backtrackSolution(grid);
        return bitmaskSolution(grid);
    }

    public int[] initialiseVariables(int[][] grid, boolean isBacktrackSolution) {
        int r = grid.length, c = grid[0].length, startRow = 0, startCol = 0, variable = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == -1) variable = isBacktrackSolution ? variable + 1 : variable ^ (1 << (i * c + j));
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        return new int[] { startRow, startCol, variable };
    }

    public int backtrackSolution(int[][] grid) {
        int[] variables = initialiseVariables(grid, true);
        int startRow = variables[0], startCol = variables[1], wallCount = variables[2];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return backtrack(startRow, startCol, wallCount, grid, visited);
    }

    public int backtrack(int currRow, int currCol, int currCount, int[][] grid, boolean[][] visited) {
        if (currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid[0].length) return 0;
        if (visited[currRow][currCol] || grid[currRow][currCol] == -1) return 0;
        if (grid[currRow][currCol] == 2) return (currCount + 1 == grid.length * grid[0].length) ? 1 : 0;
        currCount++;
        visited[currRow][currCol] = true;
        int paths = (backtrack(currRow + 1, currCol, currCount, grid, visited) +
                        backtrack(currRow - 1, currCol, currCount, grid, visited) +
                        backtrack(currRow, currCol + 1, currCount, grid, visited) +
                        backtrack(currRow, currCol - 1, currCount, grid, visited));
        visited[currRow][currCol] = false;
        return paths;
    }

    public int bitmaskSolution(int[][] grid) {
        int[] variables = initialiseVariables(grid, false);
        int startRow = variables[0], startCol = variables[1], mask = variables[2];
        return bitmask(startRow, startCol, mask, grid);
    }

    public int bitmask(int currRow, int currCol, int mask, int[][] grid) {
        if (currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid[0].length) return 0;
        if ((mask & (1 << (currRow * grid[0].length + currCol))) != 0) return 0;
        mask ^= (1 << (currRow * grid[0].length + currCol));
        if (grid[currRow][currCol] == 2) return (mask == (1 << grid.length * grid[0].length) - 1) ? 1 : 0;
        return (bitmask(currRow + 1, currCol, mask, grid) +
                bitmask(currRow - 1, currCol, mask, grid) +
                bitmask(currRow, currCol + 1, mask, grid) +
                bitmask(currRow, currCol - 1, mask, grid));
    }
}
