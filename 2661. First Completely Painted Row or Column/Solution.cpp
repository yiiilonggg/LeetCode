class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size(), low = m * n;
        vector<int> cols(n, 0);
        unordered_map<int, int> time;
        for (int i = 0; i < m * n; i++) time[arr[i]] = i;
        for (int i = 0; i < m; i++) {
            int rows = 0;
            for (int j = 0; j < n; j++) {
                rows = max(rows, time[mat[i][j]]);
                cols[j] = max(cols[j], time[mat[i][j]]);
            }
            low = min(low, rows);
        }
        for (int c : cols) low = min(low, c);
        return low;
    }
};