class Solution:
    def countBits(self, n: int) -> List[int]:
        if n == 0: return [0]
        if n == 1: return [0, 1]
        res = [0 for i in range(n + 1)]
        res[1] = 1
        left, gap = 1, 1
        for right in range(2, n + 1):
            if right == left + gap:
                res[right] = 1
                left = right
                gap *= 2
            else:
                res[right] = res[right - gap] + 1
        return res
