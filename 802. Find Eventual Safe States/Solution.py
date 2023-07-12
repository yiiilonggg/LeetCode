class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        self.loop = [0 for i in range(n)]
        res = []
        for i in range(n):
            if self.dfs(graph, i, set()): res.append(i)
        return res
    
    def dfs(self, graph, curr, visited):
        if curr in visited: return False
        if self.loop[curr] != 0: return self.loop[curr] == 1
        visited.add(curr)
        for neighbour in graph[curr]:
            if not self.dfs(graph, neighbour, visited):
                self.loop[neighbour] = -1
                return False
        visited.remove(curr)
        self.loop[curr] = 1
        return True
