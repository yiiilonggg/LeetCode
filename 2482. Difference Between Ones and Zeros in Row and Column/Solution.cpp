class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int r = grid.size(), c = grid[0].size();
        vector<int> onesrows(r, 0), onescols(c, 0);
        vector<vector<int>> res(r, vector<int>(c, 0));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    onesrows[i]++;
                    onescols[j]++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = 2 * (onesrows[i] + onescols[j]) - r - c;
            }
        }
        return res;
    }
};
