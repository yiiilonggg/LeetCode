class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        graph = [[] for i in range(n)]
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        size, dp = [1 for i in range(n)], [0 for i in range(n)]
        self.findSizeAndDP(0, -1, size, dp, graph)
        res = [0 for i in range(n)]
        self.dfs(0, -1, size, dp, res, graph)
        return res

    def findSizeAndDP(self, curr, parent, size, dp, graph):
        for neighbour in graph[curr]:
            if neighbour == parent: continue
            self.findSizeAndDP(neighbour, curr, size, dp, graph)
            size[curr] += size[neighbour]
            dp[curr] += dp[neighbour] + size[neighbour]

    def reroot(self, fromNode, toNode, size, dp):
        dp[fromNode] -= dp[toNode] + size[toNode]
        size[fromNode] -= size[toNode]
        dp[toNode] += dp[fromNode] + size[fromNode]
        size[toNode] += size[fromNode]

    def dfs(self, curr, parent, size, dp, res, graph):
        res[curr] = dp[curr]
        for neighbour in graph[curr]:
            if neighbour == parent: continue
            self.reroot(curr, neighbour, size, dp)
            self.dfs(neighbour, curr, size, dp, res, graph)
            self.reroot(neighbour, curr, size, dp)
