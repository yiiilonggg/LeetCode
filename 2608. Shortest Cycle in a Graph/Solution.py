class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        self.res = 1001
        self.visited = [-1 for i in range(n)]
        self.path = [False for i in range(n)]
        self.graph = [[] for i in range(n)]
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        for i in range(n):
            if self.visited[i] == -1: self.dfs(i, -1, 0)
        return -1 if self.res == 1001 else self.res
    
    def dfs(self, curr, prev, depth):
        if self.path[curr]:
            self.res = min(self.res, depth - self.visited[curr])
            return
        if depth > self.res: return
        self.visited[curr] = depth
        self.path[curr] = True
        for i in self.graph[curr]:
            if i == prev: continue
            self.dfs(i, curr, depth + 1)
        self.path[curr] = False