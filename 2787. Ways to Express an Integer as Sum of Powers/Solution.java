class Solution {
    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        int curr = 1, mod = 1000000007;
        while (Math.pow(curr, x) <= n) {
            powers.add((int) Math.pow(curr, x));
            curr++;
        }
        int p = powers.size();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i : powers) {
            for (int j = n; j >= 0; j--) {
                if (j >= i) dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }
        return dp[n];
    }
}
