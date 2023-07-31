class Solution {
    long[][] dp = new long[101][10];
    long mod = 1000000007;
    public int countSteppingNumbers(String low, String high) {
        Arrays.fill(dp[1], 1);
        return (int) ((mod + count(high) - count(low) + check(low)) % mod);
    }

    public long check(String x) {
        for (int i = 1; i < x.length(); i++) {
            if (Math.abs(x.charAt(i) - x.charAt(i - 1)) != 1) return 0L;
        }
        return 1L;
    }

    public long count(String x) {
        long res = 0;
        for (int i = 1; i < x.length() + 1; i++) {
            for (int d = 1; d < 10; d++) {
                res = (res + dfs(i, d, x, i == x.length())) % mod;
            }
        }
        return res;
    }

    public long dfs(int i, int d, String x, boolean lim) {
        if (d < 0 || d > 9) return 0;
        if (lim && (d > x.charAt(x.length() - i) - '0')) return 0;
        if (i == 1) return dp[i][d];
        lim = (lim && (d == x.charAt(x.length() - i) - '0'));
        if (lim) return (dfs(i - 1, d - 1, x, true) + dfs(i - 1, d + 1, x, true)) % mod;
        if (dp[i][d] != 0) return dp[i][d] - 1;
        dp[i][d] = (1 + dfs(i - 1, d - 1, x, false) + dfs(i - 1, d + 1, x, false)) % mod;
        return dp[i][d] - 1;
    }
}
