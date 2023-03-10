class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        c, r = time // (n - 1), time % (n - 1)
        return 1 + r if c % 2 == 0 else n - r