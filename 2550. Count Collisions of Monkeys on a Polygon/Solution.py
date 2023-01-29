class Solution:
    def monkeyMove(self, n: int) -> int:
        high, MOD, res = self.MSB(n) >> 1, 1000000007, 2
        while high > 0:
            res = (res * res) % MOD
            if (high & n) != 0: res *= 2
            high >>= 1
        return ((res + MOD) - 2) % MOD

    def MSB(self, n):
        l = -1
        while n > 0:
            n >>= 1
            l += 1
        return 1 << l