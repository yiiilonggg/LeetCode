# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.res = 100001
        self.prev = -1
        self.dfs(root)
        return self.res

    def dfs(self, node):
        if node.left: self.dfs(node.left)
        if self.prev > -1:
            self.res = min(self.res, node.val - self.prev)
        self.prev = node.val
        if node.right: self.dfs(node.right)
