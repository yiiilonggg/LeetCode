class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        n = len(scores)
        combined = sorted(list(zip(scores, ages)), key = lambda x: (x[1], x[0]))
        dp = [0 for i in range(n)]
        for i in range(n):
            dp[i] = combined[i][0]
            for j in range(i):
                if combined[j][0] <= combined[i][0]: dp[i] = max(dp[i], dp[j] + combined[i][0])
        return max(dp)