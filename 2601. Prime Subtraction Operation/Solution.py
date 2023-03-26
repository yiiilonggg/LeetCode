import bisect

class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        self.primes, self.fastPrimes = self.findPrimes()
        return self.backtrack(nums, len(nums) - 2)

    def backtrack(self, nums, curr):
        if curr == -1: return True
        if nums[curr] < nums[curr + 1]: return self.backtrack(nums, curr - 1)
        x = nums[curr] - nums[curr + 1]
        if x in self.fastPrimes: x += 1
        c = bisect.bisect_left(self.primes, x)
        if c == len(self.primes) or nums[curr] - self.primes[c] <= 0: return False
        nums[curr] -= self.primes[c]
        return self.backtrack(nums, curr - 1)

    def findPrimes(self):
        primes = []
        sieve = [True for i in range(1000)]
        for i in range(2, 1000):
            if not sieve[i]: continue
            for j in range(i + i, 1000, i): sieve[j] = False
            primes.append(i)
        return primes, set(primes)