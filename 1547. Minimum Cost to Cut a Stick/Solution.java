class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] updates = new int[m + 2];
        for (int i = 1; i <= m; i++) updates[i] = cuts[i - 1];
        updates[m + 1] = n;
        int[][] dp = new int[m + 2][m + 2];
        for (int diff = 2; diff < m + 2; diff++) {
            for (int left = 0; left < m + 2 - diff; left++) {
                int right = left + diff, curr = 1000000000;
                for (int mid = left + 1; mid < right; mid++) {
                    curr = Math.min(curr, dp[left][mid] + dp[mid][right] + updates[right] - updates[left]);
                }
                dp[left][right] = curr;
            }
        }
        return dp[0][m + 1];
    }
}
