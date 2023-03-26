class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        n, res = len(edges), -1
        self.visited = [False for i in range(n)]
        for i in range(n):
            if not self.visited[i]: res = max(res, self.dfs(edges, i, i, 0))
        return res
    
    def dfs(self, edges, curr, start, depth):
        if curr == -1: return -1
        if curr == start and depth > 0: return depth
        if self.visited[curr]: return -1
        self.visited[curr] = True
        res = self.dfs(edges, edges[curr], start, depth + 1)
        if res == -1: self.visited[curr] = False
        return res