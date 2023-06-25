class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(61):
            x = num1 - k * num2
            if x >= 0 and self.countBits(x) <= k <= x:
                return k
        return -1

    def countBits(self, x):
        count = 0
        while x > 0:
            if (x & 1) == 1: count += 1
            x >>= 1
        return count
