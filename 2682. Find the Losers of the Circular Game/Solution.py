class Solution:
    def circularGameLosers(self, n: int, k: int) -> List[int]:
        b = [False for i in range(n)]
        i, j, c, a = 1, 0, 0, 0
        while (True):
            if b[c]: break
            b[c] = True
            c = (c + i * k) % (n)
            i += 1
        for d in range(n):
            if not b[d]: a += 1
        res = [0 for i in range(a)]
        for d in range(n):
            if not b[d]:
                res[j] = d + 1
                j += 1
        return res