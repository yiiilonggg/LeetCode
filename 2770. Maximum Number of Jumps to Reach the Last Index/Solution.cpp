class Solution {
public:
    int maximumJumps(vector<int>& nums, int target) {
        int n = nums.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[i] == 0) continue;
            for (int j = i + 1; j < n; j++) {
                if (abs(nums[i] - nums[j]) <= target) dp[j] = max(dp[j], dp[i] + 1);
            }
        }
        return (dp[n - 1] == 0 ? -1 : dp[n - 1]);
    }
};
