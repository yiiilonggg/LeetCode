class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        n = len(capacity)
        diff = [capacity[i] - rocks[i] for i in range(n)]
        total = sum(diff)
        if total <= additionalRocks: return n
        diff = sorted(diff)
        for i in range(n):
            if diff[i] > additionalRocks: return i
            additionalRocks -= diff[i]
        return n
