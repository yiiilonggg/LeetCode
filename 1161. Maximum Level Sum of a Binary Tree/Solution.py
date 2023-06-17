# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        high, level, currLevel = root.val, 1, 1
        q = [root]
        while q:
            l = len(q)
            curr = 0
            for i in range(l):
                node = q.pop(0)
                curr += node.val
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            if curr > high:
                high, level = curr, currLevel
            currLevel += 1
        return level
