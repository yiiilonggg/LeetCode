class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        row, col = len(matrix), len(matrix[0])
        res =[[0 for r in range(row)] for c in range(col)]
        for r in range(row):
            for c in range(col):
                res[c][r] = matrix[r][c]
        return res
