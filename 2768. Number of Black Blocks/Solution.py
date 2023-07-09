class Solution:
    def countBlackBlocks(self, m: int, n: int, coordinates: List[List[int]]) -> List[int]:
        d = dict()
        res = [0 for i in range(5)]
        for x, y in coordinates:
            for i in range(-1, 1):
                for j in range(-1, 1):
                    nx, ny = x + i, y + j
                    if nx < 0 or ny < 0 or nx >= m - 1 or ny >= n - 1: continue
                    d[(x + i, y + j)] = 1 if (x + i, y + j) not in d else d[(x + i, y + j)] + 1
        for (x, y), c in d.items():
            res[c] += 1
        res[0] = (m - 1) * (n - 1) - sum(res[1:])
        return res
