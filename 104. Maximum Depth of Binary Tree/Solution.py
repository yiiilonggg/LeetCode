# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        res = 0
        if root == None: return 0
        q = [root]
        while q:
            l = len(q)
            for i in range(l):
                curr = q.pop(0)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            res += 1
        return res