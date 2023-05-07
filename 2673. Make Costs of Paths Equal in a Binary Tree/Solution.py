class Solution:
    def minIncrements(self, n: int, cost: List[int]) -> int:
        self.res = 0
        self.dfs(1, cost)
        return self.res
        
    def dfs(self, curr, cost):
        if curr * 2 > len(cost): return 0
        left, right = cost[curr * 2 - 1] + self.dfs(curr * 2, cost), cost[curr * 2] + self.dfs(curr * 2 + 1, cost)
        self.res += abs(left - right)
        return max(left, right)