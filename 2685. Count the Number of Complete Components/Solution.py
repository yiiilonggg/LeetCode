class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        uf = UFDS(n)
        p = set()
        for x, y in edges: uf.union(x, y)
        for i in range(n):
            q = uf.find(i)
            if q in p: continue
            if uf.isCCC(q): p.add(q)
        return len(p)

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
        self.size = [1 for i in range(n)]
        self.edges = [0 for i in range(n)]
    
    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def same(self, x, y):
        return self.find(x) == self.find(y)

    def union(self, x, y):
        if self.same(x, y):
            self.edges[self.find(x)] += 1
            return
        a, b = self.find(x), self.find(y)
        if self.rank[a] > self.rank[b]:
            self.parent[b] = a
            self.size[a] += self.size[b]
            self.edges[a] += self.edges[b] + 1
        else:
            self.parent[a] = b
            self.size[b] += self.size[a]
            self.edges[b] += self.edges[a] + 1
            if self.rank[a] == self.rank[b]: self.rank[b] += 1
    
    def isCCC(self, x):
        return self.edges[x] == self.size[x] * (self.size[x] - 1) // 2