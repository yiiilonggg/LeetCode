class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        int n = grid.size(), res = 0;
        vector<vector<int>> colwise(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colwise[i][j] = grid[j][i];
            }
        }
        for (vector<int> row : grid) {
            for (vector<int> col : colwise) {
                bool flag = true;
                for (int i = 0; i < n; i++) {
                    if (row[i] != col[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) res++;
            }
        }
        return res;
        
    }
};
