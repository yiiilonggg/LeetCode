class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        unordered_map<int, int> dp;
        int high = 0;
        for (const auto& a : arr) {
            dp[a] = (dp.find(a - difference) == dp.end()) ? 1 : dp[a - difference] + 1;
        }
        for (const auto& [k, v] : dp) high = max(high, v);
        return high;
    }
};
