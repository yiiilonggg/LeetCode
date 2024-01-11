# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0
        return self.dfs(root, root.val, root.val)
    def dfs(self, curr, low, high):
        if curr == None: return high - low
        low, high = min(low, curr.val), max(high, curr.val)
        return max(self.dfs(curr.left, low, high), self.dfs(curr.right, low, high))
