class Solution:
    def distinctIntegers(self, n: int) -> int:
        seen = set()
        seen.add(n)
        for i in range(n, 0, -1):
            for j in range(1, n):
                if i % j == 1: seen.add(j)
        return len(seen)