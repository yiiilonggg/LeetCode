class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        high = 0
        graph = [[] for i in range(n)]
        for i in range(n):
            if i == headID: continue
            graph[manager[i]].append((i, informTime[manager[i]]))
        q = [(headID, 0)]
        while q:
            curr, time = q.pop(0)
            high = max(high, time)
            for sub, inform in graph[curr]:
                q.append((sub, time + inform))
        return high
