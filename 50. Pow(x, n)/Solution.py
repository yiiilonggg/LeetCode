class Solution:
    def myPow(self, x: float, n: int) -> float:
        return self.r(x, n) if n >= 0 else 1 / self.r(x, -n)
    def r(self, x, p):
        if p == 0: return 1
        if p % 2 == 0: return self.r(x * x, p // 2)
        return self.r(x * x, (p - 1) // 2) * x
