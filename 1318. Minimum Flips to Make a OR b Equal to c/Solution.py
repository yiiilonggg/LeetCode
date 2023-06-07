class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        count = 0
        while a or b or c:
            j, k, l = a & 1, b & 1, c & 1
            if l == 0:
                count += j + k
            else:
                if j == 0 and k == 0:
                    count += 1
            a >>= 1
            b >>= 1
            c >>= 1
        return count
