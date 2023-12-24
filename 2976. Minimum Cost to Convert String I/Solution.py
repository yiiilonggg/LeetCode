class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        l = 'abcdefghijklmnopqrstuvwxyz'
        graph = dict()
        w = {c:{d:float('inf') if d != c else 0 for d in l} for c in l}
        for x, y, z, in zip(original, changed, cost):
            w[x][y] = min(w[x][y], z)
        for k in l:
            for i in l:
                for j in l:
                    w[i][j] = min(w[i][j], w[i][k] + w[k][j])
        t = 0
        for i, c in enumerate(source):
            if w[c][target[i]] == float('inf'): return -1
            t += w[c][target[i]]
        return t
