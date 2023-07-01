class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        moves = [[1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [-1, -1], [1, -1], [-1, 1]]
        grid =[[0 for i in range(col)] for j in range(row)]
        uf = UFDS(row * col + 2)
        for i, (x, y) in enumerate(cells):
            x, y = x - 1, y - 1
            grid[x][y] = 1
            idx = x * col + y + 1
            for a, b in moves:
                nx, ny = x + a, y + b
                if nx < 0 or ny < 0 or nx >= row or ny >= col: continue
                if grid[nx][ny] == 0: continue
                nidx = nx * col + ny + 1
                uf.union(idx, nidx)
            if y == 0: uf.union(idx, 0)
            if y == col - 1: uf.union(idx, row * col + 1)
            if uf.same(0, row * col + 1): return i
        return -1

class UFDS:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
    
    def find(self, x):
        if x != self.parent[x]: self.parent[x] = self.find(self.parent[x])
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
