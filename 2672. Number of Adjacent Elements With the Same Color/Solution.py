class Solution:
    def colorTheArray(self, n: int, queries: List[List[int]]) -> List[int]:
        l, a = len(queries), 0
        cols, res = [0 for i in range(n)], [0 for i in range(l)]
        for j, (i, c) in enumerate(queries):
            if c != cols[i]:
                if i > 0 and cols[i - 1] != 0 and cols[i - 1] == cols[i] and cols[i - 1] != c: a -= 1
                if i < n - 1 and cols[i + 1] != 0 and cols[i + 1] == cols[i] and cols[i + 1] != c: a -= 1
                cols[i] = c
                if i > 0 and cols[i - 1] == c: a += 1
                if i < n - 1 and cols[i + 1] == c: a += 1
            res[j] = a
        return res