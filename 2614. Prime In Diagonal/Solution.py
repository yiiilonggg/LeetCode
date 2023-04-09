class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        n, res = len(nums), 0
        for i in range(n):
            if self.isPrime(nums[i][i]): res = max(res, nums[i][i])
            if self.isPrime(nums[i][n - i - 1]): res = max(res, nums[i][n - i - 1])
        return res

    def isPrime(self, x):
        if x == 2: return True
        if x < 2 or x % 2 == 0: return False
        for i in range(3, int(sqrt(x)) + 1):
            if x % i == 0: return False
        return True