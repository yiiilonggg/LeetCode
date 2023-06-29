class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        int m = grid.size(), n = grid[0].length();
        unordered_map<int, unordered_map<int, unordered_set<int>>> seen;
        vector<vector<int>> movement = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        deque<vector<int>> q;
        int moves = 0, keys = 0, locks = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@') {
                    q.push_back(vector<int> { 0, i, j });
                } else if (isalpha(grid[i][j])) {
                    if (islower(grid[i][j])) {
                        keys |= (1 << (int)(grid[i][j] - 'a'));
                    } else {
                        locks |= (1 << (int)(grid[i][j] - 'A'));
                    }
                }
            }
        }
        while (!q.empty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int currKeys = q.front()[0], x = q.front()[1], y = q.front()[2];
                q.pop_front();
                if (currKeys == keys) return moves;
                if (seen.find(currKeys) != seen.end()) {
                    if (seen[currKeys].find(x) != seen[currKeys].end()) {
                        if (seen[currKeys][x].find(y) != seen[currKeys][x].end()) continue;
                    } else {
                        unordered_set<int> s;
                        seen[currKeys][x] = s;
                    }
                } else {
                    unordered_map<int, unordered_set<int>> m;
                    unordered_set<int> s;
                    seen[currKeys] = m;
                    seen[currKeys][x] = s;
                }
                seen[currKeys][x].insert(y);
                for (vector<int> move : movement) {
                    int nx = x + move[0], ny = y + move[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (grid[nx][ny] == '#') continue;
                    if (seen.find(currKeys) != seen.end() && seen[currKeys].find(nx) != seen[currKeys].end() && seen[currKeys][nx].find(ny) != seen[currKeys][nx].end()) continue;
                    if (isalpha(grid[nx][ny])) {
                        if (isupper(grid[nx][ny])) {
                            if (((1 << (int)(grid[nx][ny] - 'A')) & currKeys) == 0) continue;
                            q.push_back(vector<int> { currKeys, nx, ny });
                        } else {
                            if (((1 << (int)(grid[nx][ny] - 'a')) & currKeys) != 0) {
                                q.push_back(vector<int> { currKeys, nx, ny });
                            } else {
                                q.push_back(vector<int> { (1 << (int)(grid[nx][ny] - 'a')) | currKeys, nx, ny });
                            }
                        }
                    } else {
                        q.push_back(vector<int> { currKeys, nx, ny });
                    }
                }
            }
            moves++;
        }
        return -1;
    }
};
