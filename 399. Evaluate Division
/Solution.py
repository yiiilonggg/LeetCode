class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        q = len(queries)
        self.graph, res = dict(), [0 for i in range(q)]
        for i, (x, y) in enumerate(equations):
            if x not in self.graph: self.graph[x] = []
            if y not in self.graph: self.graph[y] = []
            self.graph[x].append((y, values[i]))
            self.graph[y].append((x, 1 / values[i]))
        for i, (x, y) in enumerate(queries):
            res[i] = self.dfs(x, y, set(), 1)
        return res
    def dfs(self, curr, target, visited, v):
        if curr in visited or curr not in self.graph: return -1
        if curr == target: return v
        visited.add(curr)
        for neighbour, w in self.graph[curr]:
            foll = self.dfs(neighbour, target, visited, v * w)
            if foll != -1: return foll
        return -1