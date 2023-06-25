class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        int n = locations.size();
        long long MOD = 1000000007;
        vector<vector<long>> dp(n, vector<long>(fuel + 1, 0));
        for (int i = 0; i <= fuel; i++) dp[finish][i] = 1;
        for (int f = 0; f <= fuel; f++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (abs(locations[i] - locations[j]) <= f)
                        dp[i][f] = (dp[i][f] + dp[j][f - abs(locations[i] - locations[j])]) % MOD;
                }
            }
        }
        return (int) dp[start][fuel];
    }
};
