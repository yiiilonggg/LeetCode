class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        res, n = 0, len(mat)
        for i in range(n):
            res += mat[i][i] + mat[i][n - i - 1]
        return res if n % 2 == 0 else res - mat[n // 2][n // 2]