class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        n, l = len(obstacles), 0
        res, heights = [1 for i in range(n)], []
        for i, h in enumerate(obstacles):
            idx = bisect.bisect_right(heights, h)
            if idx == len(heights):
                heights.append(h)
            else:
                heights[idx] = h
            res[i] = idx + 1
        return res