# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        self.nodes = []
        self.dfs(root)
        s = sorted(self.nodes)
        return min([s[i] - s[i - 1] for i in range(1, len(s))])
    def dfs(self, root):
        if not root: return
        self.nodes.append(root.val)
        self.dfs(root.left)
        self.dfs(root.right)