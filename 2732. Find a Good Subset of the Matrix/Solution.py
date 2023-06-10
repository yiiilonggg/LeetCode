class Solution:
    def goodSubsetofBinaryMatrix(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        seen = dict()
        for i in range(m):
            if self.colBits(grid[i]) in seen: continue
            seen[self.colBits(grid[i])] = i
        mask = (1 << n) - 1
        print(mask, seen)
        for i in range(mask + 1):
            if i not in seen: continue
            for j in range(mask + 1):
                if j not in seen: continue
                if (i & j) == 0:
                    if i == j: return [seen[i]]
                    return [min(seen[i], seen[j]), max(seen[i], seen[j])]
        return []

    def colBits(self, col):
        res = 0
        for c in col:
            res |= c
            res <<= 1
        return res >> 1
