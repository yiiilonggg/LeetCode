class Solution {
public:
    int maxNonDecreasingLength(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), high = 1;
        vector<vector<int>> dp(n, vector<int>(2, 0));
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (nums1[i] < nums1[i - 1]) ? max(dp[i][0], 1) : max(dp[i][0], dp[i - 1][0] + 1);
            dp[i][0] = (nums1[i] < nums2[i - 1]) ? max(dp[i][0], 1) : max(dp[i][0], dp[i - 1][1] + 1);
            dp[i][1] = (nums2[i] < nums1[i - 1]) ? max(dp[i][1], 1) : max(dp[i][1], dp[i - 1][0] + 1);
            dp[i][1] = (nums2[i] < nums2[i - 1]) ? max(dp[i][1], 1) : max(dp[i][1], dp[i - 1][1] + 1);
            high = max(high, max(dp[i][0], dp[i][1]));
        }
        return high;
    }
};
