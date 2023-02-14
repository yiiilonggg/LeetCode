class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = []
        m, n, carry, total = len(a), len(b), 0, 0
        for i in range(1, min(m, n) + 1):
            total = ord(a[m - i]) + ord(b[n - i]) - 2 * ord('0') + carry
            res.append(str(total % 2))
            carry = 1 if total > 1 else 0
        for i in range(min(m, n) + 1, m + 1):
            total = ord(a[m - i]) - ord('0') + carry
            res.append(str(total % 2))
            carry = 1 if total > 1 else 0
        for i in range(min(m, n) + 1, n + 1):
            total = ord(b[n - i]) - ord('0') + carry
            res.append(str(total % 2))
            carry = 1 if total > 1 else 0
        if carry > 0: res.append(str(1))
        return ''.join(reversed(res))