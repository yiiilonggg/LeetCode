# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root: return False
        return self.dfs(root.left, root.right)
    def dfs(self, left, right):
        if not left and not right: return True
        if left and right:
            if left.val == right.val:
                return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)
        return False