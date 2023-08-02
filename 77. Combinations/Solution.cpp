class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        if (k == 0) {
            vector<int> r;
            res.push_back(r);
            return res;
        }
        for (int i = k; i < n + 1; i++) {
            for (vector<int> prev : combine(i - 1, k - 1)) {
                prev.push_back(i);
                res.push_back(prev);
            }
        }
        return res;
    }
};
