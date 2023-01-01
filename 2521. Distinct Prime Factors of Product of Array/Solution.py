class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        primes = set()
        for n in nums:
            for i in range(2, ceil(sqrt(n)) + 1):
                if n % i == 0:
                    primes.add(i)
                    while n % i == 0: n /= i
            if n > 1: primes.add(n)
        return len(primes)
