# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.res = 0
        self.dfs(root, 0)
        return self.res
    def dfs(self, curr, total):
        if not curr: return
        if not curr.left and not curr.right:
            self.res += total + curr.val
            return
        self.dfs(curr.left, (total + curr.val) * 10)
        self.dfs(curr.right, (total + curr.val) * 10)