class Solution {
    public int[][] g;
    public int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1} };
    public int n, m;
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        g = grid;
        int res = 0;
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
            dfs(i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i);
            dfs(n - 1, i);
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (g[i][j] == 0) continue;
                res += dfs(i, j);
            }
        }
        return res;
    }
    public int dfs(int x, int y) {
        if (g[x][y] == 0) return 0;
        int curr = 1;
        g[x][y] = 0;
        for (int[] move : moves) {
            int nx = x + move[0], ny = y + move[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (g[nx][ny] == 0) continue;
            curr += dfs(nx, ny);
        }
        return curr;
    }
}