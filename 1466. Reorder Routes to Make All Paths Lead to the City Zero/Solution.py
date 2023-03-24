class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        s1, s2 = [], []
        uf = UFDS(n)
        for x, y in connections:
            a, b = uf.find(x), uf.find(y)
            if a == 0 or b == 0:
                uf.union(a, b)
            else:
                s1.append([x, y])
        while s1 or s2:
            while s1:
                x, y = s1.pop()
                a, b = a, b = uf.find(x), uf.find(y)
                if a == 0 or b == 0:
                    uf.union(a, b)
                else:
                    s2.append([x, y])
            while s2:
                x, y = s2.pop()
                a, b = a, b = uf.find(x), uf.find(y)
                if a == 0 or b == 0:
                    uf.union(a, b)
                else:
                    s1.append([x, y])
        return uf.count

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.count = 0

    def find(self, x):
        if self.parent[x] != x: self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def same(self, x, y):
        return self.find(x) == self.find(y)

    def union(self, x, y):
        if self.same(x, y): return
        a, b = self.find(x), self.find(y)
        if a == 0:
            self.parent[b] = a
            self.count += 1
        else:
            self.parent[a] = b