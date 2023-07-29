class Solution:
    def soupServings(self, n: int) -> float:
        m = ceil(n / 25)
        self.memo = dict()
        for i in range(1, m + 1):
            if self.r(i, i) > 1 - 0.00001: return 1
        return self.r(m, m)

    def r(self, a, b):
        if a <= 0 and b <= 0: return 0.5
        if a <= 0: return 1
        if b <= 0: return 0
        if (a, b) in self.memo: return self.memo[(a, b)]
        w = self.r(a - 4, b)
        x = self.r(a - 3, b - 1)
        y = self.r(a - 2, b - 2)
        z = self.r(a - 1, b - 3)
        self.memo[(a, b)] = 0.25 * (w + x + y + z)
        return self.memo[(a, b)]
