class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        uf = UFDS(n)
        for x, y, w in roads:
            uf.union(x, y, w)
        return uf.getDist(1)

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n + 1)]
        self.rank = [0 for i in range(n + 1)]
        self.dist = [10001 for i in range(n + 1)]

    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def same(self, x, y):
        return self.find(x) == self.find(y)
    
    def union(self, x, y, w):
        a, b = self.find(x), self.find(y)
        self.dist[a] = min(self.dist[a], self.dist[b], w)
        self.dist[b] = min(self.dist[a], self.dist[b], w)
        if self.same(x, y): return
        if self.rank[a] < self.rank[b]:
            self.parent[a] = b
        else:
            self.parent[b] = a
            if self.rank[a] == self.rank[b]: self.rank[a] += 1

    def getDist(self, x):
        return self.dist[self.find(x)]