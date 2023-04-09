class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n, res, processed = len(colors), 0, 0
        dp = [[0 for i in range(26)] for j in range(n)]
        graph = [[] for i in range(n)]
        indeg = [0 for i in range(n)]
        q = []
        for x, y in edges:
            graph[x].append(y)
            indeg[y] += 1
        for i in range(n):
            if indeg[i] == 0: q.append(i)
        while q:
            l = len(q)
            for i in range(l):
                curr = q.pop(0)
                processed += 1
                dp[curr][ord(colors[curr]) - ord('a')] += 1
                res = max(res, dp[curr][ord(colors[curr]) - ord('a')])
                for j in graph[curr]:
                    for k in range(26):
                        dp[j][k] = max(dp[j][k], dp[curr][k])
                    indeg[j] -= 1
                    if indeg[j] == 0: q.append(j)
        return -1 if processed < n else res