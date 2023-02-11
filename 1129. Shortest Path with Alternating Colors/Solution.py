class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        self.dist = 1
        self.res = [inf for i in range(n)]
        self.q = []
        redGraph, blueGraph = [[] for i in range(n)], [[] for i in range(n)]
        redVisited, blueVisited = [False for i in range(n)], [False for i in range(n)]
        self.res[0] = 0
        self.q.append([0, 0])
        self.q.append([0, 1])
        for x, y in redEdges: redGraph[x].append(y)
        for x, y in blueEdges: blueGraph[x].append(y)
        while self.q:
            l = len(self.q)
            for i in range(l):
                curr, col = self.q.pop(0)
                neighbours = blueGraph[curr] if col == 0 else redGraph[curr]
                for neighbour in neighbours:
                    if col == 0:
                        self.helper(blueVisited, neighbour, 1)
                    else:
                        self.helper(redVisited, neighbour, 0)
            self.dist += 1
        for i in range(n):
            if self.res[i] == inf: self.res[i] = -1
        return self.res

    def helper(self, visited, curr, nextCol):
        if visited[curr]: return
        visited[curr] = True
        self.res[curr] = min(self.res[curr], self.dist)
        self.q.append([curr, nextCol])