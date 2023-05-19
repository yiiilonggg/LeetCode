class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        return dfs(questions, 0);
    }
    public long dfs(int[][] questions, int curr) {
        if (curr >= questions.length) return 0;
        if (dp[curr] != 0) return dp[curr];
        dp[curr] = Math.max(dp[curr] + questions[curr][0] + dfs(questions, curr + questions[curr][1] + 1), dfs(questions, curr + 1));
        return dp[curr];
    }
}