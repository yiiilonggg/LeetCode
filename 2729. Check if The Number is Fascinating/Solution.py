class Solution:
    def isFascinating(self, n: int) -> bool:
        s = str(n) + str(2 * n) + str(3 * n)
        a = [c for c in s]
        if any([b == '0' for b in a]): return False
        return len(set(a)) == 9 and len(a) == 9
