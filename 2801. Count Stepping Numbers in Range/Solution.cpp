class Solution {
public:
    vector<vector<long long>> dp;
    long long mod = 1000000007;
    int countSteppingNumbers(string low, string high) {
        dp.assign(101, vector<long long>(10, 0));
        for (int i = 0; i < 10; i++) dp[1][i] = 1;
        return (int) ((mod + count(high) - count(low) + check(low)) % mod);
    }

    long long check(string x) {
        for (int i = 1; i < x.length(); i++) {
            if (abs(x[i] - x[i - 1]) != 1) return 0;
        }
        return 1;
    }

    long long count(string x) {
        long long res = 0;
        for (int i = 1; i < x.length() + 1; i++) {
            for (int d = 1; d < 10; d++) {
                res = (res + dfs(i, d, x, i == x.length())) % mod;
            }
        }
        return res;
    }

    long long dfs(int i, int d, string x, bool lim) {
        if (d < 0 || d > 9) return 0;
        if (lim && (d > x[x.length() - i] - '0')) return 0;
        if (i == 1) return dp[i][d];
        lim = (lim && (d == x[x.length() - i] - '0'));
        if (lim) return (dfs(i - 1, d - 1, x, true) + dfs(i - 1, d + 1, x, true)) % mod;
        if (dp[i][d] != 0) return dp[i][d] - 1LL;
        dp[i][d] = (1LL + dfs(i - 1, d - 1, x, false) + dfs(i - 1, d + 1, x, false)) % mod;
        return dp[i][d] - 1LL;
    }
};
