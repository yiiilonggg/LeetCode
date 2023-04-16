# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q, p = [root], [[root, root.val]]
        prevSum, prevL = 0, 0
        while p:
            currSum, l = 0, len(q)
            for i in range(l):
                curr = q.pop(0)
                currSum += curr.val
                t = 0
                if curr.left: t += curr.left.val
                if curr.right: t += curr.right.val
                if curr.left:
                    q.append(curr.left)
                    p.append([curr.left, t])
                if curr.right:
                    q.append(curr.right)
                    p.append([curr.right, t])
            for i in range(prevL):
                curr, t = p.pop(0)
                curr.val = prevSum - t
            prevSum, prevL = currSum, l
        return root