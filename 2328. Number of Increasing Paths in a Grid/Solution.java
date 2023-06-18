class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length, MOD = 1000000007, res = 0;
        int[][] coords = new int[m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coords[i * n + j][0] = i;
                coords[i * n + j][1] = j;
            }
        }
        int[][] moves = { { 0, 1 }, { 0, -1, }, { 1, 0 }, { -1, 0 } };
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, 1);
        Arrays.sort(coords, (a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        for (int[] c : coords) {
            for (int[] move : moves) {
                int nx = c[0] + move[0], ny = c[1] + move[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] > grid[c[0]][c[1]]) {
                    dp[nx][ny] = (dp[nx][ny] + dp[c[0]][c[1]]) % MOD;
                }
            }
        }
        for (int[] row : dp) {
            for (int r : row) {
                res = (res + r) % MOD;
            }
        }
        return res;
    }
}
