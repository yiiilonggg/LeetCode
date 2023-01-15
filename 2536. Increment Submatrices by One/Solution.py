class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        m = [[0 for i in range(n)] for j in range(n)]
        for r1, c1, r2, c2 in queries:
            m[r1][c1] += 1
            if r2 < n - 1: m[r2 + 1][c1] -= 1
            if c2 < n - 1: m[r1][c2 + 1] -= 1
            if r2 < n - 1 and c2 < n - 1: m[r2 + 1][c2 + 1] += 1
        for r in range(n):
            for c in range(1, n):
                m[r][c] += m[r][c - 1]
        for r in range(1, n):
            for c in range(n):
                m[r][c] += m[r - 1][c]
        return m