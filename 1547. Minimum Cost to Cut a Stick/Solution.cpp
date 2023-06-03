class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        int m = cuts.size();
        sort(begin(cuts), end(cuts));
        vector<int> updates;
        updates.push_back(0);
        for (int c : cuts) updates.push_back(c);
        updates.push_back(n);
        vector<vector<int>> dp(m + 2, vector<int>(m + 2, 0));
        for (int diff = 2; diff < m + 2; diff++) {
            for (int left = 0; left < m + 2 - diff; left++) {
                int right = left + diff, curr = 1000000000;
                for (int mid = left + 1; mid < right; mid++) {
                    curr = min(curr, dp[left][mid] + dp[mid][right] + updates[right] - updates[left]);
                }
                dp[left][right] = curr;
            }
        }
        return dp[0][m + 1];
    }
};
