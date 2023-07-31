class Solution:
    def countSteppingNumbers(self, low: str, high: str) -> int:
        self.dp = [[1 if i == 1 else 0 for j in range(10)] for i in range(101)]
        self.mod = 1000000007
        return (self.count(high) - self.count(low) + self.check(low)) % self.mod

    def check(self, x):
        for i in range(1, len(x)):
            if abs(int(x[i]) - int(x[i - 1])) != 1: return 0
        return 1

    def count(self, x):
        res = 0
        for i in range(1, len(x) + 1):
            for d in range(1, 10):
                res += self.dfs(i, d, x, i == len(x))
        return res

    def dfs(self, i, d, x, lim):
        if d > 9 or d < 0: return 0
        if lim and d > int(x[len(x) - i]): return 0
        if i == 1: return self.dp[i][d]
        lim = lim and (d == int(x[len(x) - i]))
        if lim:
            return (self.dfs(i - 1, d - 1, x, True) + self.dfs(i - 1, d + 1, x, True)) % self.mod
        if self.dp[i][d] != 0: return self.dp[i][d] - 1
        self.dp[i][d] = (1 + self.dfs(i - 1, d - 1, x, False) + self.dfs(i - 1, d + 1, x, False)) % self.mod
        return self.dp[i][d] - 1
