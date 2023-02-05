class Solution {
    int m, n;
    public boolean isPossibleToCutPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // return dfsSolution(grid);
        return diagonalSolution(grid);
    }

    public boolean dfsSolution(int[][] grid) {
        if (m * n == 2) return false;
        boolean[][] visited = new boolean[m][n];
        if (!dfs(grid, visited, 0, 0)) return true;
        return !dfs(grid, visited, 0, 0);
    }

    public boolean dfs(int[][] grid, boolean[][] visited, int currX, int currY) {
        if (currX == m - 1 && currY == n - 1) return true;
        if (grid[currX][currY] == 0) return false;
        if (!(currX == 0 && currY == 0) && visited[currX][currY]) return false;
        visited[currX][currY] = true;
        if (currX + 1 < m && dfs(grid, visited, currX + 1, currY)) return true;
        if (currY + 1 < n && dfs(grid, visited, currX, currY + 1)) return true;
        return false;
    }

    public boolean diagonalSolution(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (i == 0 && j == 0) continue;
                if ((i == 0 || grid[i - 1][j] == 0) && (j == 0 || grid[i][j - 1] == 0)) grid[i][j] = 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) continue;
                if (i == m - 1 && j == n - 1) continue;
                if ((i == m - 1 || grid[i + 1][j] == 0) && (j == n - 1 || grid[i][j + 1] == 0)) grid[i][j] = 0;
            }
        }
        int[] counter = new int[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                counter[i + j]++;
            }
        }
        for (int i = 1; i < m + n - 2; i++) {
            if (counter[i] < 2) return true;
        }
        return false;
    }
}