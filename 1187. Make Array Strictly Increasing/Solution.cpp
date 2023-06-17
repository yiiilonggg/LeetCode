class Solution {
public:
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        sort(begin(arr2), end(arr2));
        vector<unordered_map<int, int>> dp(2002);
        int res = dfs(0, -1, arr1, arr2, dp);
        return (res < 2001) ? res : -1;
    }
    
    int dfs(int curr, int prev, vector<int>& arr1, vector<int>& arr2, vector<unordered_map<int, int>>& dp) {
        if (curr == arr1.size()) return 0;
        if (dp[curr].find(prev) != dp[curr].end()) return dp[curr][prev];
        int cost = 2001;
        if (arr1[curr] > prev) cost = min(cost, dfs(curr + 1, arr1[curr], arr1, arr2, dp));
        int idx = upper_bound(begin(arr2), end(arr2), prev) - begin(arr2);
        if (idx < arr2.size()) cost = min(cost, 1 + dfs(curr + 1, arr2[idx], arr1, arr2, dp));
        dp[curr][prev] = cost;
        return cost;
    }
};
