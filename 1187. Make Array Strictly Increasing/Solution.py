import bisect

class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2 = sorted(arr2)
        self.dp = dict()
        res = self.dfs(0, -1, arr1, arr2)
        return res if res < 2001 else -1
    def dfs(self, curr, prev, arr1, arr2):
        if curr == len(arr1): return 0
        if (curr, prev) in self.dp: return self.dp[(curr, prev)]
        cost = 2001
        if arr1[curr] > prev: cost = min(cost, self.dfs(curr + 1, arr1[curr], arr1, arr2))
        idx = bisect_right(arr2, prev)
        if idx < len(arr2): cost = min(cost, 1 + self.dfs(curr + 1, arr2[idx], arr1, arr2))
        self.dp[(curr, prev)] = cost
        return cost
