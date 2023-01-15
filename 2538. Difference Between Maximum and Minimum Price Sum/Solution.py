class Solution:
    def maxOutput(self, n: int, edges: List[List[int]], price: List[int]) -> int:
        self.graph = [[] for i in range(n)]
        self.subtree = [0 for i in range(n)]
        self.res = 0
        self.prices = price
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        self.fillSubtree(0, -1)
        self.dfs(0, -1, 0)
        return self.res

    def fillSubtree(self, curr, parent):
        subRes = 0
        neighbours = self.graph[curr]
        for neighbour in neighbours:
            if neighbour == parent: continue
            subRes = max(subRes, self.fillSubtree(neighbour, curr))
        self.subtree[curr] = subRes + self.prices[curr]
        return self.subtree[curr]

    def dfs(self, curr, parent, fromParent):
        firstNode, secondNode, firstPath, secondPath = -1, -1, 0, 0
        neighbours = self.graph[curr]
        for neighbour in neighbours:
            if neighbour == parent: continue
            if self.subtree[neighbour] > firstPath:
                firstNode, secondNode, firstPath, secondPath = neighbour, firstNode, self.subtree[neighbour], firstPath
            elif self.subtree[neighbour] > secondPath:
                secondNode, secondPath = neighbour, self.subtree[neighbour]
        self.res = max(self.res, fromParent, firstPath)
        for neighbour in neighbours:
            if neighbour == parent: continue
            if neighbour == firstNode:
                self.dfs(neighbour, curr, self.prices[curr] + max(secondPath, fromParent))
            else:
                self.dfs(neighbour, curr, self.prices[curr] + max(firstPath, fromParent))