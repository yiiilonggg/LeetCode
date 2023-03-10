class Solution:
    def splitNum(self, num: int) -> int:
        digits = []
        while num > 0:
            digits.append(num % 10)
            num //= 10
        digits = sorted(digits)
        n = len(digits)
        res = digits[0] if n % 2 == 1 else 0
        pointer = 1 if n % 2 == 1 else 0
        while pointer < n:
            res = (res * 10) + digits[pointer] + digits[pointer + 1]
            pointer += 2
        return res