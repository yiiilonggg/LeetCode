class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int curr = 1;
        vector<vector<int>> res(n, vector<int>(n, 0));
        for (int layer = 0; layer < n / 2 + 1; layer++) {
            for (int i = layer; i < n - layer; i++) {
                res[layer][i] = curr;
                curr++;
            }
            for (int i = layer + 1; i < n - layer; i++) {
                res[i][n - layer - 1] = curr;
                curr++;
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                res[n - layer - 1][i] = curr;
                curr++;
            }
            for (int i = n - layer - 2; i > layer; i--) {
                res[i][layer] = curr;
                curr++;
            }
        }
        return res;
    }
};