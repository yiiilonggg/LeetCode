class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left, right = max(weights), sum(weights)
        while left < right:
            mid, curr, day = left + (right - left) // 2, 0, 1
            for w in weights:
                if curr + w > mid:
                    curr = 0
                    day += 1
                curr += w
            if day > days:
                left = mid + 1
            else:
                right = mid
        return left