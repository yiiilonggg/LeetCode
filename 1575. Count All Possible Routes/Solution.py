class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        n, MOD = len(locations), 1000000007
        dp = [[1 if j == finish else 0 for i in range(fuel + 1)] for j in range(n)]
        for f in range(fuel + 1):
            for i in range(n):
                for j in range(n):
                    if i == j: continue
                    if (abs(locations[i] - locations[j]) <= f):
                        dp[i][f] = (dp[i][f] + dp[j][f - abs(locations[i] - locations[j])]) % MOD
        return dp[start][fuel]
