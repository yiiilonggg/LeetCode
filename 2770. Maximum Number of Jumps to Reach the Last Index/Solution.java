class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[i] == 0) continue;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }
        return (dp[n - 1] == 0 ? -1 : dp[n - 1]);
    }
}
