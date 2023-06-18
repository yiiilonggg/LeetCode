class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size(), MOD = 1000000007, res = 0;
        vector<vector<int>> coords(m * n, vector<int>(3, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coords[i * n + j][0] = grid[i][j];
                coords[i * n + j][1] = i;
                coords[i * n + j][2] = j;
            }
        }
        vector<vector<int>> moves = { { 0, 1 }, { 0, -1, }, { 1, 0 }, { -1, 0 } };
        vector<vector<int>> dp(m, vector<int>(n, 1));
        sort(begin(coords), end(coords));
        for (auto c : coords) {
            for (auto move : moves) {
                int nx = c[1] + move[0], ny = c[2] + move[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] > grid[c[1]][c[2]]) {
                    dp[nx][ny] = (dp[nx][ny] + dp[c[1]][c[2]]) % MOD;
                }
            }
        }
        for (auto row : dp) {
            for (int r : row) {
                res = (res + r) % MOD;
            }
        }
        return res;
    }
};
