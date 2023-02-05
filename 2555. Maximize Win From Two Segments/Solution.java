class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length, left = 0, res = 0;
        int[] dp = new int[n + 1];
        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) left++;
            dp[right + 1] = Math.max(dp[right], right - left + 1);
            res = Math.max(res, dp[left] + right - left + 1);
        }
        return res;
    }
}