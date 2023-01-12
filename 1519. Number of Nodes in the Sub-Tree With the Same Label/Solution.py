class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        self.graph = [[] for i in range(n)]
        self.labels = labels
        self.res = [0 for i in range(n)]
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        self.dfs(0, -1, [0 for i in range(26)])
        return self.res
    
    def dfs(self, curr, parent, letters):
        neighbours = self.graph[curr]
        idx = ord(self.labels[curr]) - ord('a')
        prev = letters[idx]
        letters[idx] += 1
        for neighbour in neighbours:
            if neighbour == parent: continue
            self.dfs(neighbour, curr, letters)
        self.res[curr] = letters[idx] - prev