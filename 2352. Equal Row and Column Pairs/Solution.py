class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n, res = len(grid), 0
        colwise = list(zip(*grid))
        for row in grid:
            for col in colwise:
                flag = True
                for i in range(n):
                    if row[i] != col[i]:
                        flag = False
                        break
                if flag: res += 1
        return res
