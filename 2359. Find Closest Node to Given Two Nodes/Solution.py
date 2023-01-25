import heapq
class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        n = len(edges)
        visitedOne, visitedTwo = [False for i in range(n)], [False for i in range(n)]
        qOne, qTwo = [node1], [node2]
        self.pq = []
        while qOne or qTwo:
            self.perform(edges, qOne, visitedTwo, visitedOne)
            self.perform(edges, qTwo, visitedOne, visitedTwo)
            if self.pq: return heapq.heappop(self.pq)
        return -1

    def perform(self, edges, q, visitedToCheck, visitedToEdit):
        l = len(q)
        for i in range(l):
            curr = q.pop(0)
            if visitedToCheck[curr]: heapq.heappush(self.pq, curr)
            if visitedToEdit[curr]: continue
            visitedToEdit[curr] = True
            if edges[curr] == -1: continue
            q.append(edges[curr])