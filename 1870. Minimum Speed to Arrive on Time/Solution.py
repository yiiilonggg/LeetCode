class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        left, right = 1, 10000000
        check = lambda x: sum([ceil(a / x) if i < len(dist) - 1 else a / x for i, a in enumerate(dist)])
        while left < right:
            mid = (left + right) // 2
            if check(mid) <= hour:
                right = mid
            else:
                left = mid + 1
        return left if check(left) <= hour else -1
