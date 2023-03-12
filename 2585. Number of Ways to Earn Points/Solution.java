class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        long mod = 1000000007;
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int[] t : types) {
            for (int i = target; i > 0; i--) {
                for (int j = 1; j <= t[0] && i - t[1] * j >= 0; j++) {
                    dp[i] = (dp[i] + dp[i - t[1] * j]) % mod;
                }
            }
        }
        return (int) dp[target];
    }
}