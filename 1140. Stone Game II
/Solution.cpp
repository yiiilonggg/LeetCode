class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        vector<vector<vector<int>>> dp(2, vector<vector<int>>(n + 1, vector<int>(n + 1, -1)));
        return dfs(piles, dp, 0, 0, 1);
    }
    int dfs(vector<int>& piles, vector<vector<vector<int>>>& dp, int p, int i, int m) {
        int n = piles.size();
        if (i == n) return 0;
        if (dp[p][i][m] != -1) return dp[p][i][m];
        int res = p == 1 ? 1000000 : -1, s = 0;
        for (int x = 1; x <= min(2 * m, n - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = max(res, s + dfs(piles, dp, 1, i + x, max(m, x)));
            }
            else {
                res = min(res, dfs(piles, dp, 0, i + x, max(m, x)));
            }
        }
        return dp[p][i][m] = res;
    }
};
