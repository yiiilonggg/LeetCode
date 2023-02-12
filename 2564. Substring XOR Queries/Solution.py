class Solution:
    def substringXorQueries(self, s: str, queries: List[List[int]]) -> List[List[int]]:
        master = dict()
        m = len(s)
        res = []
        for i in range(m):
            if s[i] == '0':
                if 0 not in master:
                    master[0] = [i, i]
                continue
            for j in range(1, 32):
                x = int(s[i:i + j], 2)
                if x in master: continue
                master[x] = [i, j + i - 1]
        for x, y in queries:
            target = x ^ y
            if target in master:
                res.append(master[target])
            else:
                res.append([-1, -1])
        return res