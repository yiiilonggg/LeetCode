class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: x[1])
        count, upper = 0, intervals[0][0] - 1;
        for a, b in intervals:
            if a < upper:
                count += 1
            else:
                upper = b
        return count
