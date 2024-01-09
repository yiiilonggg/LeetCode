# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        return self.dfs(root1, []) == self.dfs(root2, [])
    def dfs(self, curr, sequence):
        if curr == None: return sequence
        if curr.left == None and curr.right == None:
            sequence.append(curr.val)
        else:
            self.dfs(curr.left, sequence)
            self.dfs(curr.right, sequence)
        return sequence
