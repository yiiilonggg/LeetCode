class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n, low = len(mat), len(mat[0]), len(mat) * len(mat[0])
        cols = [0 for i in range(n)]
        time = {arr[i] : i for i in range(m * n)}
        for i in range(m):
            rows = 0
            for j in range(n):
                rows = max(rows, time[mat[i][j]])
                cols[j] = max(cols[j], time[mat[i][j]])
            low = min(low, rows)
        for c in cols: low = min(low, c)
        return low