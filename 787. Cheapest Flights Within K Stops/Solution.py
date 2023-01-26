class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        # return self.bellmanFord(n, flights, src, dst, k)
        visited = [float(inf) for i in range(n)]
        graph = [[] for i in range(n)]
        for x, y, z in flights: graph[x].append((y, z))
        q = [[src, 0]]
        cheapest = float(inf)
        while q and k >= -1:
            l = len(q)
            for i in range(l):
                prev, price = q.pop(0)
                if prev == dst: cheapest = min(cheapest, price)
                if visited[prev] <= price: continue
                visited[prev] = price
                neighbours = graph[prev]
                for x, y in neighbours:
                    q.append([x, y + price])
            k -= 1
        return -1 if cheapest == float(inf) else cheapest

    def bellmanFord(self, n, flights, src, dst, k):
        dist = [float(inf) for i in range(n)]
        dist[src] = 0
        for i in range(k + 1):
            temp = [d for d in dist]
            for x, y, z in flights:
                if dist[x] == float(inf): continue
                temp[y] = min(temp[y], dist[x] + z)
            dist = temp
        return dist[dst] if dist[dst] != float(inf) else -1