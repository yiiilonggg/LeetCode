class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        long MOD = 1000000007;
        long[][] dp = new long[n][fuel + 1];
        Arrays.fill(dp[finish], 1);
        for (int f = 0; f <= fuel; f++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (Math.abs(locations[i] - locations[j]) <= f)
                        dp[i][f] = (dp[i][f] + dp[j][f - Math.abs(locations[i] - locations[j])]) % MOD;
                }
            }
        }
        return (int) dp[start][fuel];
    }
}
