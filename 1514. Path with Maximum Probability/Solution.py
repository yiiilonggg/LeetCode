import heapq

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        visited = [False for i in range(n)]
        graph = [[] for i in range(n)]
        for i, (x, y) in enumerate(edges):
            graph[x].append((y, math.log(succProb[i])))
            graph[y].append((x, math.log(succProb[i])))
        pq = [(0, start)]
        while pq:
            p, curr = heappop(pq)
            if visited[curr]: continue
            visited[curr] = True
            if curr == end: return math.exp(-p)
            for neighbour, q in graph[curr]:
                if visited[neighbour]: continue
                heappush(pq, (p - q, neighbour))
        return 0
