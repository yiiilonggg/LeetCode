import heapq
class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        n, res = len(vals), len(vals)
        self.parent = [i for i in range(n)]
        count = [1 for i in range(n)]
        pq = []
        for e in edges:
            heapq.heappush(pq, (max(vals[e[0]], vals[e[1]]), e))
        while pq:
            high, edge = heapq.heappop(pq)
            x, y = self.find(edge[0]), self.find(edge[1])
            if vals[x] == vals[y]:
                res += count[x] * count[y]
                self.parent[x] = y
                count[y] += count[x]
            elif vals[x] > vals[y]:
                self.parent[y] = x
            else:
                self.parent[x] = y
        return res
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]