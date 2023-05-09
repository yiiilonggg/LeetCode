class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        top, left, bottom, right = 0, 0, len(matrix) - 1, len(matrix[0]) - 1
        res = []
        while top <= bottom and left <= right:
            for i in range(left, right + 1): res.append(matrix[top][i])
            if top == bottom: break
            for i in range(top + 1, bottom + 1): res.append(matrix[i][right])
            if left == right: break
            for i in range(right - 1, left - 1, -1): res.append(matrix[bottom][i])
            for i in range(bottom - 1, top, -1): res.append(matrix[i][left])
            top += 1
            bottom -= 1
            left += 1
            right -= 1
        return res