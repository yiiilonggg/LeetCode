class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n == 1: return matrix[0][0]
        dp = [[0 for i in range(n)] for j in range(n)]
        dp[0] = matrix[0]
        for i in range(1, n):
            dp[i][0] = matrix[i][0] + min(dp[i - 1][0], dp[i - 1][1])
            for j in range(1, n - 1):
                dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1:j + 2])
            dp[i][-1] = matrix[i][-1] + min(dp[i - 1][-1], dp[i - 1][-2])
        return min(dp[-1])
