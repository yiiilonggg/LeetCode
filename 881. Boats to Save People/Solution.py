class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        n, count = len(people), 0
        left, right = 0, n - 1
        p = sorted(people)
        while left <= right:
            if p[left] + p[right] <= limit: left += 1
            right -= 1
            count += 1
        return count