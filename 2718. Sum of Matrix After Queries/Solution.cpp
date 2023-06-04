class Solution {
public:
    long long matrixSumQueries(int n, vector<vector<int>>& queries) {
        unordered_set<int> r, c;
        int rows = 0, cols = 0;
        long long res = 0;
        for (int i = queries.size() - 1; i >= 0 && rows < n && cols < n; i--) {
            int t = queries[i][0], idx = queries[i][1], val = queries[i][2];
            if (t == 0) {
                if (r.find(idx) != r.end()) continue;
                rows++;
                res += val * (n - cols);
                r.insert(idx);
            } else {
                if (c.find(idx) != c.end()) continue;
                cols++;
                res += val * (n - rows);
                c.insert(idx);
            }
        }
        return res;
        
    }
};
