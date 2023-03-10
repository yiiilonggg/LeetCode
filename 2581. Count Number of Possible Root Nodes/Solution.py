class Solution:
    def rootCount(self, edges: List[List[int]], guesses: List[List[int]], k: int) -> int:
        n, count, self.res = len(edges) + 1, 0, 0
        self.graph = [[] for i in range(n)]
        self.guess = [set() for i in range(-1, n)]
        self.parent = [-1 for i in range(n)]
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        for x, y in guesses:
            self.guess[x].add(y)
        self.fillParent(0, -1)
        for i in range(n):
            if i in self.guess[self.parent[i]]: count += 1
        if count >= k: self.res += 1
        for neighbour in self.graph[0]: self.dfs(neighbour, 0, count, k)
        return self.res
    
    def fillParent(self, curr, prev):
        self.parent[curr] = prev
        for neighbour in self.graph[curr]:
            if neighbour == prev: continue
            self.fillParent(neighbour, curr)
    
    def dfs(self, curr, prev, count, k):
        if prev in self.guess[curr]: count += 1
        if curr in self.guess[prev]: count -= 1
        if count >= k: self.res += 1
        for neighbour in self.graph[curr]:
            if neighbour == prev: continue
            self.dfs(neighbour, curr, count, k)