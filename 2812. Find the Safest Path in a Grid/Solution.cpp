class Solution {
public:
    int n;
    vector<vector<int>> safe;
    vector<vector<int>> moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        n = grid.size();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return 0;
        int dist = 1;
        safe.assign(n, vector<int>(n, 0));
        deque<pair<int, int>> d;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) d.push_back(pair(i, j));
            }
        }
        while (!d.empty()) {
            int l = d.size();
            for (int i = 0; i < l; i++) {
                pair<int, int> curr = d.front();
                d.pop_front();
                for (const auto& m : moves) {
                    int nx = curr.first + m[0], ny = curr.second + m[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] == 1 || safe[nx][ny] != 0) continue;
                    safe[nx][ny] = dist;
                    d.push_back(pair(nx, ny));
                }
            }
            dist++;
        }
        int left = 0, right = dist - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(left)) ? left : left - 1;
    }

    bool check(int z) {
        deque<pair<int, int>> d;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        d.push_back(pair(0, 0));
        while (!d.empty()) {
            pair<int, int> curr = d.front();
            d.pop_front();
            if (visited[curr.first][curr.second] || safe[curr.first][curr.second] < z) continue;
            if (curr.first == n - 1 && curr.second == n - 1) return true;
            visited[curr.first][curr.second] = true;
            for (const auto& m : moves) {
                int nx = curr.first + m[0], ny = curr.second + m[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || safe[nx][ny] < z) continue;
                d.push_back(pair(nx, ny));
            }
        }
        return false;
    }
};
