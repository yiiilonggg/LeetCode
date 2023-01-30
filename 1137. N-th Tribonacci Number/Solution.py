class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        if n <= 2: return 1
        prev, prev1, prev2 = 1, 1, 0
        for i in range(3, n + 1):
            curr = prev + prev1 + prev2
            prev, prev1, prev2 = curr, prev, prev1
        return prev