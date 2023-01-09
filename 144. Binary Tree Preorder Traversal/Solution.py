# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        self.dfs(root)
        return self.res
    def dfs(self, curr):
        if not curr: return
        self.res.append(curr.val)
        self.dfs(curr.left)
        self.dfs(curr.right)