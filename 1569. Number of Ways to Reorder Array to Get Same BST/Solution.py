class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        n = len(nums)
        self.MOD = 1000000007
        self.pascals = []
        for i in range(n + 1):
            self.pascals.append([1 for j in range(i + 1)])
            for j in range(1, i):
                self.pascals[i][j] = (self.pascals[i - 1][j - 1] + self.pascals[i - 1][j]) % self.MOD
        return (self.dfs(nums) - 1) % self.MOD
    
    def dfs(self, nums):
        if len(nums) < 3: return 1
        left, right = [], []
        l = len(nums)
        for i in range(1, l):
            if nums[i] < nums[0]:
                left.append(nums[i])
            else:
                right.append(nums[i])
        countLeft, countRight = self.dfs(left) % self.MOD, self.dfs(right) % self.MOD
        return (((countLeft * countRight) % self.MOD) * self.pascals[l - 1][len(left)]) % self.MOD
