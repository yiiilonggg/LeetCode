class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        return [max([len(str(grid[j][i])) for j in range(m)]) for i in range(n)]