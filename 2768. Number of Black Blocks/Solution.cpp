class Solution {
public:
    vector<long long> countBlackBlocks(int m, int n, vector<vector<int>>& coordinates) {
        unordered_map<long, int> d;
        vector<long long> res(5, 0);
        for (const auto& c : coordinates) {
            int x = c[0], y = c[1];
            for (int i = -1; i <= 0; i++) {
                for (int j = -1; j <= 0; j++) {
                    int nx = x + i, ny = y + j;
                    long long idx = 1LL * nx * n + ny;
                    if (nx < 0 || ny < 0 || nx >= m - 1 || ny >= n - 1) continue;
                    d[idx] = (d.find(idx) == d.end()) ? 1 : d[idx] + 1;
                }
            }
        }
        for (const auto& [k, v] : d) res[v]++;
        res[0] = 1LL * (m - 1) * (n - 1) - (res[1] + res[2] + res[3] + res[4]);
        return res;
    }
};
