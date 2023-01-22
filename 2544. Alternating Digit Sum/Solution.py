class Solution:
    def alternateDigitSum(self, n: int) -> int:
        count, res = 0, 0
        while n > 0:
            if count % 2 == 1:
                res += n % 10
            else:
                res -= n % 10
            n //= 10
            count += 1
        if count % 2 == 0: return res
        return -res