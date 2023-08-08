class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rleft, rright = 0, len(matrix) - 1
        while rleft < rright:
            mid = (rleft + rright) // 2
            if matrix[mid][-1] < target:
                rleft = mid + 1
            else:
                rright = mid
        cleft, cright = 0, len(matrix[0]) - 1
        while cleft < cright:
            mid = (cleft + cright) // 2
            if matrix[rleft][mid] < target:
                cleft = mid + 1
            else:
                cright = mid
        return matrix[rleft][cleft] == target
