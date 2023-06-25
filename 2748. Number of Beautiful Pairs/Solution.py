class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        n, count = len(nums), 0
        for i in range(n):
            for j in range(i + 1, n):
                first, second = nums[i], nums[j] % 10
                while first // 10 > 0: first //= 10
                if self.gcd(first, second) == 1: count += 1
        return count
    
    def gcd(self, x, y):
        if y > x: return self.gcd(y, x)
        if y == 0: return x
        return self.gcd(y, x % y)
