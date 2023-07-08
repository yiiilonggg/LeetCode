class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        int n = weights.size();
        vector<int> diffs;
        for (int i = 1; i < n; i++) {
            diffs.push_back(weights[i] + weights[i - 1]);
        }
        sort(begin(diffs), end(diffs));
        long long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += diffs[n - i - 2] - diffs[i];
        }
        return res;
    }
};
