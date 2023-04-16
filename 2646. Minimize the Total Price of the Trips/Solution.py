class Solution:
    def minimumTotalPrice(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        self.visited, self.price = [0 for i in range(n)], price
        self.graph = [[] for i in range(n)]
        self.n = n
        self.memo = dict([[i, dict()] for i in range(n)])
        for x, y in edges:
            self.graph[x].append(y)
            self.graph[y].append(x)
        for x, y in trips:
            self.dfs(x, y, -1)
            self.visited[y] += 1
        return self.backtrack(0, -1, False)

    def dfs(self, curr, end, prev):
        if curr == end: return True
        for neighbour in self.graph[curr]:
            if neighbour == prev: continue
            if self.dfs(neighbour, end, curr):
                self.visited[curr] += 1
                return True
        return False

    def backtrack(self, curr, prev, prevHalf):
        if prevHalf in self.memo[curr]: return self.memo[curr][prevHalf]
        total, half = self.price[curr] * self.visited[curr], self.price[curr] * self.visited[curr] // 2
        for neighbour in self.graph[curr]:
            if neighbour == prev: continue
            total += self.backtrack(neighbour, curr, False)
        if not prevHalf:
            for neighbour in self.graph[curr]:
                if neighbour == prev: continue
                half += self.backtrack(neighbour, curr, True)
        if prevHalf:
            self.memo[curr][prevHalf] = total
        else:
            self.memo[curr][prevHalf] = min(total, half)
        return total if prevHalf else min(total, half)