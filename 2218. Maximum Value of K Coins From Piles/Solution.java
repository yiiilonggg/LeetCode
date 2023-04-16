class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int curr = 0;
                for (int l = 0; l <= Math.min(piles.get(i - 1).size() , j); l++) {
                    if (l > 0) curr += piles.get(i - 1).get(l - 1);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + curr);
                }
            }
        }
        return dp[n][k];
    }
}