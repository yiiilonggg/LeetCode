class Solution:
    def arraySign(self, nums: List[int]) -> int:
        neg = False
        for n in nums:
            if n == 0: return 0
            if n < 0: neg = not neg
        return -1 if neg else 1