class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        self.moves = [[2, 1], [-2, 1], [2, -1], [-2, -1], [1, 2], [-1, 2], [1, -2], [-1, -2]]
        self.dp = [[[0 for c in range(k + 1)] for b in range(n)] for a in range(n)]
        return self.r(n, k, row, column)
    
    def r(self, n, k, row, col):
        if row < 0 or col < 0 or row >= n or col >= n: return 0
        if k == 0: return 1
        if self.dp[row][col][k] != 0: return self.dp[row][col][k]
        res = 0.125 * sum(self.r(n, k - 1, row - r, col - c) for r, c in self.moves)
        self.dp[row][col][k] = res
        return res
