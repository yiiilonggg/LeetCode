class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        a, b, res = UFDS(n), UFDS(n), 0
        for i, x, y in edges:
            if i != 3: continue
            if a.same(x, y): res += 1
            a.union(x, y)
            b.union(x, y)
        if a.sets == 1: return len(edges) - n + 1
        for i, x, y in edges:
            if i == 1:
                if a.same(x, y): res += 1
                a.union(x, y)
            elif i == 2:
                if b.same(x, y): res += 1
                b.union(x, y)
        return -1 if a.sets > 1 or b.sets > 1 else res

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n + 1)]
        self.rank = [0 for i in range(n + 1)]
        self.sets = n
    
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
        self.sets -= 1