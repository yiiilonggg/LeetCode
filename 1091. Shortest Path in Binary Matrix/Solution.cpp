class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        vector<vector<int>> moves = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 } };
        int n = grid.size(), count = 0;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        queue<pair<int, int>> q;
        q.push(pair(0, 0));
        grid[0][0] = 1;
        while (!q.empty()) {
            int l = q.size();
            count++;
            for (int i = 0; i < l; i++) {
                int x = q.front().first, y = q.front().second;
                q.pop();
                if (x == n - 1 && y == n - 1) return count;
                for (vector<int> m : moves) {
                    int nx = x + m[0], ny = y + m[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (grid[nx][ny] == 1) continue;
                    grid[nx][ny] = 1;
                    q.push(pair(nx, ny));
                }
            }
        }
        return -1;
    }
};
