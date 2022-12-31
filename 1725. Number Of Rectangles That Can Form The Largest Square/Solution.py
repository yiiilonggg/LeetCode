class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        maxLengths = [min(r) for r in rectangles]
        return maxLengths.count(max(maxLengths))
