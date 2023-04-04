class Solution:
    def partitionString(self, s: str) -> int:
        tracker = set()
        count = 0
        for c in s:
            if c in tracker:
                count += 1
                tracker = set()
            tracker.add(c)
        return count + 1