class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        indegree = [0 for i in range(n)]
        res = []
        for x, y in edges:
            indegree[y] += 1
        for i, x in enumerate(indegree):
            if x == 0: res.append(i)
        return res