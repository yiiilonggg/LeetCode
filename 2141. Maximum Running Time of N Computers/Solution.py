class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        arr = sorted(batteries, key = lambda x: -x)
        left, right = 1, sum(batteries) // n
        while left < right:
            mid = (left + right) // 2
            if self.check(n, arr, mid):
                left = mid + 1
            else:
                right = mid - 1
        return left if self.check(n, arr, left) else left - 1
    
    def check(self, n, arr, x):
        rem = 0
        for i in range(n):
            rem += max(x - arr[i], 0)
        for i in range(n, len(arr)):
            rem -= arr[i]
        return rem <= 0
