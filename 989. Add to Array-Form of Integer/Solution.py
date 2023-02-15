class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        res = []
        n, carry, total = len(num), 0, 0
        for i in range(n - 1, -1, -1):
            total = num[i] + carry + k % 10
            res.append(total % 10)
            carry = total // 10
            k //= 10
        k += carry
        while k > 0:
            res.append(k % 10)
            k //= 10
        return reversed(res)