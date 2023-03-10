# credit to timetoai

class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        uf = UFDS(n)
        for i in range(n):
            if lcp[i][i] + i != n: return ""
            for j in range(i + 1, n):
                if lcp[i][j] + j > n or lcp[i][j] != lcp[j][i]: return ""
                if lcp[i][j] == 0: continue
                if j + 1 < n and lcp[i + 1][j + 1] + 1 != lcp[i][j]: return ""
                uf.union(i, j)
        for i in range(n):
            for j in range(i + 1, n):
                if lcp[i][j] == 0 and uf.same(i, j): return ""
                if lcp[i][j] > 0 and lcp[i][j] + j < n and uf.same(i + lcp[i][j], j + lcp[i][j]): return ""
        print(uf.parent)
        res = ['A' for i in range(n)]
        c = 'a'
        for i in range(n):
            p = uf.find(i)
            if res[p] != 'A':
                res[i] = res[p]
            else:
                if c > 'z': return ""
                res[i] = c
                c = chr(ord(c) + 1)
        return ''.join(res)

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]

    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def same(self, x, y):
        return self.find(x) == self.find(y)
    
    def union(self, x, y):
        if self.same(x, y): return
        a, b = self.find(x), self.find(y)
        self.parent[a], self.parent[b] = min(a, b), min(a, b)