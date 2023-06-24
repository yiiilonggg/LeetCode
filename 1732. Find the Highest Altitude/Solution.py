class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        curr, high = 0, 0
        for g in gain:
            curr += g
            high = max(high, curr)
        return high
