class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) {
        queue<vector<int>> q;
        int r = grid.size(), c = grid[0].size(), high = 0;
        for (int i = 0; i < r; i++) q.push(vector<int> { i, 0 });
        while (!q.empty() && q.front()[1] < c - 1) {
            vector<bool> col(r, false);
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int x = q.front()[0], y = q.front()[1];
                q.pop();
                for (int j = -1; j < 2; j++) {
                    if (x + j < 0 || x + j >= r) continue;
                    if (grid[x][y] >= grid[x + j][y + 1]) continue;
                    if (col[x + j]) continue;
                    q.push(vector<int> { x + j, y + 1});
                    col[x + j] = true;
                }
            }
            if (!q.empty()) high++;
        }
        return high;
    }
};