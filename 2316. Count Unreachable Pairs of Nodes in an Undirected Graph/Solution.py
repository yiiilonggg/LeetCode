class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        uf = UFDS(n)
        for x, y in edges: uf.union(x, y)
        reps = uf.getReps()
        res = 0
        for r in reps:
            n -= r
            res += n * r
        return res

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
        self.size = [1 for i in range(n)]
        self.disjoint = n
        self.n = n
    
    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def same(self, x, y):
        return self.find(x) == self.find(y)

    def union(self, x, y):
        if self.same(x, y): return
        a, b = self.find(x), self.find(y)
        if self.rank[a] > self.rank[b]:
            self.parent[b] = a
            self.size[a] += self.size[b]
        else:
            self.parent[a] = b
            self.size[b] += self.size[a]
            if self.rank[a] == self.rank[b]: self.rank[b] += 1
        self.disjoint -= 1
    
    def getReps(self):
        return [self.size[i] for i in range(self.n) if self.parent[i] == i]