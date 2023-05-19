class Solution {
public:
    vector<long long> dp;

    long long dfs(vector<vector<int>>& questions, int curr) {
        if (curr >= questions.size()) return 0;
        if (dp[curr] != 0) return dp[curr];
        dp[curr] = max(questions[curr][0] + dfs(questions, curr + questions[curr][1] + 1), dfs(questions, curr + 1));
        return dp[curr];
    }

    long long mostPoints(vector<vector<int>>& questions) {
        int n = questions.size();
        dp.assign(n, 0);
        return dfs(questions, 0);
    }
};