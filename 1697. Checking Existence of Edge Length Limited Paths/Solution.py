class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        q, e, j = len(queries), len(edgeList), 0
        uf = UFDS(n)
        edgeList.sort(key = itemgetter(2))
        qIdx = [[queries[i][0], queries[i][1], queries[i][2], i] for i in range(q)]
        qIdx.sort(key = itemgetter(2))
        res = [False for i in range(q)]
        for query in qIdx:
            while j < e and edgeList[j][2] < query[2]:
                uf.union(edgeList[j][0], edgeList[j][1])
                j += 1
            res[query[3]] = uf.same(query[0], query[1])
        return res

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
    
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