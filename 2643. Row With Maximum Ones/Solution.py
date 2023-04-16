class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        n = len(mat)
        res = [0, 0]
        for i in range(n):
            curr = sum(mat[i])
            if curr > res[1]:
                res[0], res[1] = i, curr
        return res