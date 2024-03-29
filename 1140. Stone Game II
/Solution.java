class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n + 1][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(piles, dp, 0, 0, 1);
    }
    public int dfs(int[] piles, int[][][] dp, int p, int i, int m) {
        if (i == piles.length) return 0;
        if (dp[p][i][m] != -1) return dp[p][i][m];
        int res = (p == 1) ? 1000000 : -1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + dfs(piles, dp, 1, i + x, Math.max(x, m)));
            } else {
                res = Math.min(res, dfs(piles, dp, 0, i + x, Math.max(x, m)));
            }
        }
        dp[p][i][m] = res;
        return res;
    }
}
