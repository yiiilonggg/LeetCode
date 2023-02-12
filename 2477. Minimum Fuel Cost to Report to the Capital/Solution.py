class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        self.res, n = 0, len(roads) + 1
        self.graph = [[] for i in range(n)]
        for x, y in roads:
            self.graph[x].append(y)
            self.graph[y].append(x)
        self.dfs(0, -1, seats, 0)
        return self.res
    
    def dfs(self, curr, parent, seats, depth):
        neighbours = self.graph[curr]
        passengers, count = 1, len(neighbours) if curr == 0 else len(neighbours) - 1
        for neighbour in neighbours:
            if neighbour == parent: continue
            incoming = self.dfs(neighbour, curr, seats, depth + 1)
            if incoming > 0:
                passengers += incoming
            else:
                count -= 1
        self.res += count + (passengers // seats) * depth
        return passengers % seats