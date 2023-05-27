class Solution {
public:
    vector<int> dp;
    int minExtraChar(string s, vector<string>& dictionary) {
        dp.assign(51, 0);
        for (int i = s.size() - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
            for (auto& d : dictionary) {
                if (s.compare(i, d.size(), d) == 0) dp[i] = min(dp[i], dp[i + d.size()]);
            }
        }
        return dp[0];
    }
};
