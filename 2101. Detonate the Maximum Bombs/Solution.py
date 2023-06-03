class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        n, high = len(bombs), 0
        self.graph = [[] for i in range(n)]
        for i, (x, y, r) in enumerate(bombs):
            for j, (a, b, c) in enumerate(bombs):
                if i == j: continue
                if (x - a) ** 2 + (y - b) ** 2 > r ** 2: continue
                self.graph[i].append(j)
        for i in range(n):
            high = max(high, self.dfs(i, set()))
        return high
    def dfs(self, curr, seen):
        if curr in seen: return 0
        seen.add(curr)
        total = 1
        for neighbour in self.graph[curr]:
            total += self.dfs(neighbour, seen)
        return total
