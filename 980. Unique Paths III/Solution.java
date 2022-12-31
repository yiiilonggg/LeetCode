class Solution {
    public int uniquePathsIII(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int startRow = 0, startCol = 0, wallCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == -1) wallCount++;
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
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
}
