class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        left, right, n = 1, 100000000000000, len(time)
        while left < right:
            mid, count = (left + right) // 2, 0
            for i in range(n):
                count += mid // time[i]
                if count > totalTrips: break
            # count = sum(mid // t for t in time)
            if count < totalTrips:
                left = mid + 1
            else:
                right = mid
        return left