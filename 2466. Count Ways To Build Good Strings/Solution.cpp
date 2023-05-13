class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        vector<long> dp(high + 1, 0);
        dp[0] = 1;
        long res = 0, mod = 1000000007;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) dp[i] += dp[i - zero];
            if (i - one >= 0) dp[i] += dp[i - one];
            dp[i] %= mod;
            if (i >= low) res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
};