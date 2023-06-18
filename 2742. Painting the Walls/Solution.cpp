class Solution {
public:
    int paintWalls(vector<int>& cost, vector<int>& time) {
        int n = cost.size();
        vector<int> dp(n + 1, 1000000007);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i], t = time[i];
            for (int j = n; j >= 0; j--) {
                dp[min(j + t + 1, n)] = min(dp[min(j + t + 1, n)], dp[j] + c);
            }
        }
        return dp[n];
    }
};
