class Solution {
public:
    int findMaxFish(vector<vector<int>>& grid) {
        int moves[4][2] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        int r = grid.size(), c = grid[0].size(), high = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) continue;
                int curr = grid[i][j];
                queue<pair<int, int>> q;
                q.push({ i, j });
                grid[i][j] = 0;
                while (!q.empty()) {
                    int x = q.front().first, y = q.front().second;
                    q.pop();
                    for (auto m : moves) {
                        int nx = x + m[0], ny = y + m[1];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if (grid[nx][ny] == 0) continue;
                        q.push( { nx, ny });
                        curr += grid[nx][ny];
                        grid[nx][ny] = 0;
                    }
                }
                high = max(high, curr);
            }
        }
        return high;
    }
};