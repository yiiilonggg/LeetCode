class Solution:
    def isReachable(self, targetX: int, targetY: int) -> bool:
        while targetX % 2 == 0: targetX //= 2
        while targetY % 2 == 0: targetY //= 2
        r = self.gcd(targetX, targetY)
        return r == 1
    
    def gcd(self, x, y):
        while y > 0:
            r = x % y
            x = y
            y = r
        return x