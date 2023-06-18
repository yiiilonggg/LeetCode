class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        MOD = 1000000007
        dp = [[1 for i in range(n)] for j in range(m)]
        coords = sorted([[i, j] for i in range(m) for j in range(n)], key = lambda x: grid[x[0]][x[1]])
        moves = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        for x, y in coords:
            for a, b in moves:
                nx, ny = x + a, y + b
                if nx < 0 or ny < 0 or nx >= m or ny >= n: continue
                if grid[nx][ny] > grid[x][y]:
                    dp[nx][ny] = (dp[nx][ny] + dp[x][y]) % MOD
        return sum(sum(row) % MOD for row in dp) % MOD
