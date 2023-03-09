class Solution:
    def squareFreeSubsets(self, nums: List[int]) -> int:
        self.masks = [  -1,   0,   1,   2,  -1,   4,   3,   8,  -1,  -1,
                         5,  16,  -1,  32,   9,   6,  -1,  64,  -1, 128,
                        -1,  10,  17, 256,  -1,  -1,  33,  -1,  -1, 512,   7]
        self.dp = [[0 for i in range(1 << 10)] for j in range(1001)]
        self.mod = 10 ** 9 + 7
        return (self.dfs(0, 0, nums) + self.mod) % self.mod

    def dfs(self, curr, mask, nums):
        if curr == len(nums): return 0
        if self.dp[curr][mask] == 0:
            self.dp[curr][mask] = (1 + self.dfs(curr + 1, mask, nums)) % self.mod
            if self.masks[nums[curr]] != -1 and (mask & self.masks[nums[curr]]) == 0:
                self.dp[curr][mask] = (self.dp[curr][mask] + 1 + self.dfs(curr + 1, mask | self.masks[nums[curr]], nums)) % self.mod
        return self.dp[curr][mask] - 1