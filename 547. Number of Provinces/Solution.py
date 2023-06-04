class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        uf = UFDS(n)
        for x in range(n):
            for y in range(n):
                if isConnected[x][y] == 1: uf.union(x, y)
        return uf.n

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
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
        else:
            self.parent[a] = b
            if self.rank[a] == self.rank[b]: self.rank[b] += 1
        self.n -= 1
