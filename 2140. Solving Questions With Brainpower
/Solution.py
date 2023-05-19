class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        self.dp = [0 for i in range(n)]
        return self.dfs(questions, 0)
    def dfs(self, questions, curr):
        if curr >= len(questions): return 0
        if self.dp[curr] != 0: return self.dp[curr]
        self.dp[curr] = max(self.dp[curr] + questions[curr][0] + self.dfs(questions, curr + questions[curr][1] + 1), self.dfs(questions, curr + 1))
        return self.dp[curr]