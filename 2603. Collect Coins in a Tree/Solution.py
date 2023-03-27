# credit to @ye15

class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        n = len(coins)
        graph = [set() for i in range(n)]
        leaves = deque()
        for x, y in edges:
            graph[x].add(y)
            graph[y].add(x)
        for i in range(n):
            while len(graph[i]) == 1 and coins[i] == 0:
                j = graph[i].pop()
                graph[j].remove(i)
                i = j
            if len(graph[i]) == 1: leaves.append(i)
        for i in range(2):
            for j in range(len(leaves)):
                curr = leaves.popleft()
                if graph[curr]:
                    v = graph[curr].pop()
                    graph[v].remove(curr)
                    if len(graph[v]) == 1: leaves.append(v)
        return sum([len(g) for g in graph])