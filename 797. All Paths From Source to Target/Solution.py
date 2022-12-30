class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        self.res = []
        self.backtrack(0, graph, [])
        return self.res
    def backtrack(self, curr, graph, currPath):
        if curr in currPath: return
        if curr == len(graph) - 1:
            self.res.append(currPath + [curr])
            return
        currPath.append(curr)
        for neighbour in graph[curr]:
            self.backtrack(neighbour, graph, currPath)
        currPath.pop()
