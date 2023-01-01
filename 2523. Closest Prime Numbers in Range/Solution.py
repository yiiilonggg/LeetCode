class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        sieve = [True for i in range(right + 1)]
        resFirst, resSecond, prev, diff = -1, -1, -1, 1000000
        for i in range(2, len(sieve)):
            if not sieve[i]: continue
            for j in range(i + i, right + 1, i): sieve[j] = False
            if i >= left:
                if prev != -1 and i - prev < diff: resFirst, resSecond, diff = prev, i, i - prev
                prev = i
        return [resFirst, resSecond]
