class Solution {
public:
    vector<int> goodSubsetofBinaryMatrix(vector<vector<int>>& grid) {
        unordered_map<int, int> seen;
        int m = grid.size(), n = grid[0].size(), mask = (1 << n) - 1;
        for (int i = 0; i < m; i++) {
            int c = colBits(grid[i]);
            if (seen.find(c) != seen.end()) continue;
            seen[c] = i;
        }
        for (int i = 0; i <= mask; i++) {
            if (seen.find(i) == seen.end()) continue;
            for (int j = 0; j <= mask; j++) {
                if (seen.find(j) == seen.end()) continue;
                if ((i & j) == 0) {
                    if (i == j) return { seen[i] };
                    return { min(seen[i], seen[j]), max(seen[i], seen[j]) };
                }
            }
        }
        return {};
    }

    int colBits(vector<int>& g) {
        int res = 0;
        for (auto c : g) {
            res |= c;
            res <<= 1;
        }
        return res >> 1;
    }
};
