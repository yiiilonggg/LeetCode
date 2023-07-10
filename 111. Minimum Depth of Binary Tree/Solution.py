# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        depth = 0
        q = [root] if root else []
        while q:
            depth += 1
            l = len(q)
            for i in range(l):
                curr = q.pop(0)
                if not curr.left and not curr.right: return depth
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
        return depth
