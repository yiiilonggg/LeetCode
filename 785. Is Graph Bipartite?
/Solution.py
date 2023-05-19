class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        self.col, self.graph = [0 for i in range(n)], graph
        for x, neighbours in enumerate(graph):
            if self.col[x] != 0: continue
            if not self.dfs(x, 1): return False
        return True

    def dfs(self, curr, color):
        if self.col[curr] != 0: return self.col[curr] == color
        self.col[curr] = color
        for neighbour in self.graph[curr]:
            if not self.dfs(neighbour, 1 if color == 2 else 2): return False
        return True