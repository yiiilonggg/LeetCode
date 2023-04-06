class Solution {
    int n, m;
    int[][] g;
    int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        g = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                if (!dfs(i, j)) count++;
            }
        }
        return count;
    }
    public boolean dfs(int x, int y) {
        boolean res = x == 0 || y == 0 || x == n - 1 || y == m - 1;
        g[x][y] = 1;
        for (int[] mo : moves) {
            int nx = x + mo[0], ny = y + mo[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (g[nx][ny] == 1) continue;
            res |= dfs(nx, ny);
        }
        return res;
    }
}