class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        self.graph = [[] for i in range(n)]
        self.apple = hasApple
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        return max(0, self.dfs(0, -1) -2)
    
    def dfs(self, curr, parent):
        neighbours = self.graph[curr]
        steps = 0
        for neighbour in neighbours:
            if neighbour == parent: continue
            steps += self.dfs(neighbour, curr)
        return steps + 2 if (self.apple[curr] or steps != 0) else 0