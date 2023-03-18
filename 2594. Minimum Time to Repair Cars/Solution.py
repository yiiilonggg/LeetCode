class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        left, right = 0, 2 ** 64
        while left < right:
            mid = (left + right) // 2
            c = sum([int(sqrt(mid // r)) for r in ranks])
            if c < cars:
                left = mid + 1
            else:
                right = mid
        return left