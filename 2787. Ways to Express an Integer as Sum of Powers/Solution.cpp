class Solution {
public:
    int numberOfWays(int n, int x) {
        vector<int> powers;
        int mod = 1000000007;
        for (int i = 1; ; i++) {
            int curr = i;
            for (int j = 1; j < x; j++) curr *= i;
            if (curr > n) break;
            powers.push_back(curr);
        }
        int p = powers.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i : powers) {
            for (int j = n; j >= 0; j--) {
                if (j >= i) dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }
        return dp[n];
    }
};
