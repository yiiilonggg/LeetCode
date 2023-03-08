class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right, n = 1, 10 ** 9, len(piles)
        while left < right:
            mid, count = (left + right) // 2, 0
            for p in piles:
                count = count + p // mid if p % mid == 0 else count + 1 + p // mid
            if count > h:
                left = mid + 1
            else:
                right = mid
        return left