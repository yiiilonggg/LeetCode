# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        if not root: return False
        q = [root]
        flag = False
        while q:
            l = len(q)
            for i in range(l):
                curr = q.pop(0)
                if curr.left:
                    if flag: return False
                    q.append(curr.left)
                else:
                    flag = True
                if curr.right:
                    if flag: return False
                    q.append(curr.right)
                else:
                    flag = True
        return True