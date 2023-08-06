class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1 or grid[-1][-1]: return 0
        self.moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        self.n, dist = len(grid), 1
        self.safe = [[0 for i in range(self.n)] for j in range(self.n)]
        q = []
        for i in range(self.n):
            for j in range(self.n):
                if grid[i][j] == 1:
                    q.append([i, j])
                    self.safe[i][j] = 0
        while q:
            l = len(q)
            for i in range(l):
                x, y = q.pop(0)
                for a, b in self.moves:
                    nx, ny = x + a, y + b
                    if nx < 0 or nx >= self.n or ny < 0 or ny >= self.n: continue
                    if grid[nx][ny] == 1 or self.safe[nx][ny] != 0: continue
                    self.safe[nx][ny] = dist
                    q.append([nx, ny])
            dist += 1
        left, right = 0, dist - 1
        while left < right:
            mid = (left + right) // 2
            if self.check(mid):
                left = mid + 1
            else:
                right = mid - 1
        return left if self.check(left) else left - 1
    
    def check(self, z):
        q = [[0, 0]]
        visited = [[False for j in range(self.n)] for i in range(self.n)]
        while q:
            currx, curry = q.pop(0)
            if visited[currx][curry] or self.safe[currx][curry] < z: continue
            if currx == self.n - 1 and curry == self.n - 1: return True
            visited[currx][curry] = True
            for a, b in self.moves:
                nx, ny = currx + a, curry + b
                if nx < 0 or nx >= self.n or ny < 0 or ny >= self.n: continue
                if visited[nx][ny] or self.safe[nx][ny] < z: continue
                q.append([nx, ny])
        return False
