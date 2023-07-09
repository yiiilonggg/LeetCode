class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length, high = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (nums1[i] < nums1[i - 1]) ? Math.max(dp[i][0], 1) : Math.max(dp[i][0], dp[i - 1][0] + 1);
            dp[i][0] = (nums1[i] < nums2[i - 1]) ? Math.max(dp[i][0], 1) : Math.max(dp[i][0], dp[i - 1][1] + 1);
            dp[i][1] = (nums2[i] < nums1[i - 1]) ? Math.max(dp[i][1], 1) : Math.max(dp[i][1], dp[i - 1][0] + 1);
            dp[i][1] = (nums2[i] < nums2[i - 1]) ? Math.max(dp[i][1], 1) : Math.max(dp[i][1], dp[i - 1][1] + 1);
            high = Math.max(high, Math.max(dp[i][0], dp[i][1]));
        }
        return high;
    }
}
