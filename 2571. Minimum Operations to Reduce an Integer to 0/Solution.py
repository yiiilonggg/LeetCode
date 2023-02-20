class Solution:
    def minOperations(self, n: int) -> int:
        count = 0
        while n:
            if n & 1 == 1:
                if n == 1 or n & 2 == 0:
                    n -= 1
                else:
                    n += 1
                count += 1
            else:
                n >>= 1
        return count