"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        return self.recurse(grid, 0, 0, len(grid))
    def recurse(self, grid, x, y, n):
        if n == 1: return Node(grid[x][y] == 1, True)
        topleft, topright, bottomleft, bottomright = self.recurse(grid, x, y, n // 2), self.recurse(grid, x, y + n // 2, n // 2), self.recurse(grid, x + n // 2, y, n // 2), self.recurse(grid, x + n // 2, y + n // 2, n // 2)
        if topleft.isLeaf and topright.isLeaf and bottomright.isLeaf and bottomright.isLeaf and topleft.val == topright.val and topright.val == bottomleft.val and bottomleft.val == bottomright.val:
            return Node(topleft.val, True)
        return Node(False, False, topleft, topright, bottomleft, bottomright)