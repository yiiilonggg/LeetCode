class Solution:
    def matrixSumQueries(self, n: int, queries: List[List[int]]) -> int:
        seen = set()
        rows, cols, res, i = 0, 0, 0, len(queries) - 1
        while i >= 0 and rows < n and cols < n:
            t, idx, val = queries[i]
            if (t, idx) in seen:
                i -= 1
                continue
            seen.add((t, idx))
            if t == 0:
                rows += 1
                res += val * (n - cols)
            else:
                cols += 1
                res += val * (n - rows)
            i -= 1
        return res
