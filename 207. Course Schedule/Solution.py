class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0 for i in range(numCourses)]
        graph = [[] for i in range(numCourses)]
        for a, b in prerequisites:
            graph[b].append(a)
            indegree[a] += 1
        q = []
        visited = 0
        for i in range(numCourses):
            if indegree[i] == 0: q.append(i)
        while q:
            curr = q.pop(0)
            visited += 1
            for neighbour in graph[curr]:
                indegree[neighbour] -= 1
                if indegree[neighbour] == 0: q.append(neighbour)
        return visited == numCourses
