class Solution {
public:
    int r, c;
    queue<vector<int>> q;
    vector<vector<int>> g;
    vector<vector<int>> moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    vector<vector<bool>> visited;
    int shortestBridge(vector<vector<int>>& grid) {
        r = grid.size();
        c = grid[0].size();
        g = grid;
        for (int i = 0; i < r; i++) {
            vector<bool> s(c, false);
            visited.push_back(s);
        }
        int count = 0;
        for (int i = 0; i < r && q.empty(); i++) {
            for (int j = 0; j < c && q.empty(); j++) {
                if (grid[i][j] == 0) continue;
                find(i, j);
            }
        }
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                vector<int> curr = q.front();
                q.pop();
                for (vector<int> m : moves) {
                    int nx = curr[0] + m[0], ny = curr[1] + m[1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if (visited[nx][ny]) continue;
                    if (grid[nx][ny] == 1) return count;
                    visited[nx][ny] = true;
                    vector<int> foll = { nx, ny };
                    q.push(foll);
                }
            }
            count++;
        }
        return -1;
    }

    void find(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c) return;
        if (visited[x][y] || g[x][y] == 0) return;
        visited[x][y] = true;
        vector<int> foll = { x, y };
        q.push(foll);
        for (vector<int> m : moves) {
            find(x + m[0], y + m[1]);
        }
    }
};
