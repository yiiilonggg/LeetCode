class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        uf = UFDS(n)
        for x, y in connections: uf.union(x, y)
        return -1 if uf.disjoint - 1 > uf.free else uf.disjoint - 1

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
        self.disjoint = n
        self.free = 0

    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def union(self, x, y):
        if self.same(x, y):
            self.free += 1
            return
        a, b = self.find(x), self.find(y)
        if self.rank[a] > self.rank[b]:
            self.parent[b] = a
        else:
            self.parent[a] = b
            if self.rank[a] == self.rank[b]: self.rank[b] += 1
        self.disjoint -= 1