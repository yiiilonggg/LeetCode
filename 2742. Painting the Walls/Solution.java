class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000007);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i], t = time[i];
            for (int j = n; j >= 0; j--) {
                dp[Math.min(j + t + 1, n)] = Math.min(dp[Math.min(j + t + 1, n)], dp[j] + c);
            }
        }
        return dp[n];
    }
}
